package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Администратор on 29.07.2016.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    private JTabbedPane tabbedPane;
    private JTextPane htmlTextPane;
    private JEditorPane plainTextPane;
    private UndoManager undoManager;
    private UndoListener undoListener;

    public View()
    {
        this.tabbedPane = new JTabbedPane();
        this.htmlTextPane = new JTextPane();
        this.plainTextPane = new JEditorPane();
        this.undoManager = new UndoManager();
        this.undoListener = new UndoListener(undoManager);
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (IllegalAccessException e){
            ExceptionHandler.log(e);
        }catch (ClassNotFoundException e){
            ExceptionHandler.log(e);
        }catch (InstantiationException e){
            ExceptionHandler.log(e);
        }catch (UnsupportedLookAndFeelException e){
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }
    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        this.setVisible(true);
    }

    public void initMenuBar(){
        JMenuBar menu = new JMenuBar();
        MenuHelper.initFileMenu(this, menu);
        MenuHelper.initEditMenu(this, menu);
        MenuHelper.initStyleMenu(this, menu);
        MenuHelper.initAlignMenu(this, menu);
        MenuHelper.initColorMenu(this, menu);
        MenuHelper.initFontMenu(this, menu);
        MenuHelper.initHelpMenu(this, menu);
        getContentPane().add(menu, BorderLayout.NORTH);
    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane);
        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPane1);
        tabbedPane.setPreferredSize(new Dimension(800, 600));
        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(listener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void selectedTabChanged(){
        if (tabbedPane.getSelectedIndex() == 0)
            controller.setPlainText(plainTextPane.getText());
        else if (tabbedPane.getSelectedIndex() == 1)
            plainTextPane.setText(controller.getPlainText());
        resetUndo();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){
        return undoManager.canRedo();
    }
    public void undo(){
        try
        {
            undoManager.undo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }

    }
    public void redo(){
        try
        {
            undoManager.redo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(this, "HTML editor", "About", JOptionPane.INFORMATION_MESSAGE);
    }


    public void exit(){
        controller.exit();
    }
}
