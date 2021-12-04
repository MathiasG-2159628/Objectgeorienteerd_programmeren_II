package website;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Browser{

    private BrowserWindowView mBrowserView;
    private BrowserToolbarView mBrowserToolbarView;
    private BrowserController mBrowserController;
    private BrowserModel mBrowserModel;

    public Browser(){
        mBrowserModel = new BrowserModel();
        mBrowserController = new BrowserController(mBrowserModel);
        mBrowserView = new BrowserWindowView(mBrowserModel, mBrowserController);
        mBrowserToolbarView = new BrowserToolbarView(mBrowserModel, mBrowserController);
        mBrowserController.setModel(mBrowserModel);
        mBrowserView.setModel(mBrowserModel);

    }

    public void createGUI() {
        JFrame frame = new JFrame("Webbrowser");

        frame.add(mBrowserToolbarView.getGUI(), BorderLayout.NORTH);
        frame.add(mBrowserView.getGUI(), BorderLayout.CENTER);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    public static void createAndShowGUI(){
        Browser browser = new Browser();
        browser.createGUI();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
