package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Администратор on 29.07.2016.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view)
    {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void exit(){
        System.exit(0);
    }
    public void init(){
        createNewDocument();
    }
    public void resetDocument(){
        if (document !=null)
            document.removeUndoableEditListener(view.getUndoListener());
        document = (HTMLDocument)new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){
        resetDocument();
        Reader reader = new StringReader(text);
        try
        {
            new HTMLEditorKit().read(reader, document, 0);
        }
        catch (BadLocationException e)
        {
            ExceptionHandler.log(e);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public String getPlainText(){
        Writer writer = new StringWriter();
        try
        {
            new HTMLEditorKit().write(writer,document,0,document.getLength());
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e)
        {
            e.printStackTrace();
        }
        return writer.toString();
    }
    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
            currentFile = null;

    }

    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int n = fileChooser.showOpenDialog(view);
        if (n == fileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(Reader reader = new FileReader(currentFile)){
                new HTMLEditorKit().read(reader,document,0);
                view.resetUndo();
            }catch (Exception e){
                ExceptionHandler.log(e);
            }

        }
    }
    public void saveDocument(){
        if (currentFile !=null){
            view.selectHtmlTab();
            try(Writer writer = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }catch (Exception e){
                ExceptionHandler.log(e);
            }
        }else saveDocumentAs();
    }
    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int n = fileChooser.showSaveDialog(view);
        if (n == fileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try(Writer writer = new FileWriter(currentFile)){
             new HTMLEditorKit().write(writer,document,0,document.getLength());
            }catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }


    public static void main(String... args){
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
