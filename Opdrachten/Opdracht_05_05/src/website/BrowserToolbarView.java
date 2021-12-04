package website;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class BrowserToolbarView extends AbstractView {
    private JTextField jAddressBar;
    private JButton jButtonPrev;
    private JButton jButtonNext;
    private JButton jButtonBookmark;
    private JButton jButtonViewBookmarks;
    private JPanel mPanel;

    public BrowserToolbarView(Observable model, Controller controller){
        mPanel = new JPanel();

        mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.X_AXIS));
        jButtonPrev = new JButton("<--");
        jButtonNext = new JButton("-->");
        jButtonBookmark = new JButton("*");
        jButtonViewBookmarks = new JButton("Bookmarks");
        jButtonPrev.setSize(10,10);
        jButtonNext.setSize(10,10);
        jButtonBookmark.setSize(10, 10);
        jButtonViewBookmarks.setSize(20, 10);


        jAddressBar = new JTextField();
        jAddressBar.setSize(new Dimension(200, 500));
        jAddressBar.setText("hello");
        jAddressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = jAddressBar.getText();
                try {
                    //jEditorPane.setPage(url);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        });

        mPanel.add(jButtonPrev);
        mPanel.add(jButtonNext);
        mPanel.add(jAddressBar);
        mPanel.add(jButtonBookmark);
        mPanel.add(jButtonViewBookmarks);
    }

    public JComponent getGUI(){
        return mPanel;
    }
}
