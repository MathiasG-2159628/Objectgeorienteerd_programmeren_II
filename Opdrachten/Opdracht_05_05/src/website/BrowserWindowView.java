package website;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

import java.io.IOException;
import java.util.Observable;

public class BrowserWindowView extends AbstractView{
    private JPanel mPanel;
    private JEditorPane jEditorPane;


    public BrowserWindowView(Observable model, Controller controller){
        mPanel = new JPanel();
        jEditorPane = new JEditorPane();
        jEditorPane.setSize(200, 200);


        try {
            jEditorPane.setPage("https://www.google.be");
        } catch (IOException e) {
            e.printStackTrace();
        }
        jEditorPane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() != HyperlinkEvent.EventType.ACTIVATED) {
                    return;
                }
                JEditorPane srcPane = (JEditorPane)e.getSource();
                if (e instanceof HTMLFrameHyperlinkEvent) {
                    HTMLDocument doc = (HTMLDocument)srcPane.getDocument();
                    doc.processHTMLFrameHyperlinkEvent((HTMLFrameHyperlinkEvent)e);
                } else {
                    String url = e.getURL().toString();
                    srcPane.setText(url);
                    try {
                        srcPane.setPage(url);
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });

        mPanel.add(new JScrollPane(jEditorPane));
    }


    public JComponent getGUI(){
        return mPanel;
    }
}
