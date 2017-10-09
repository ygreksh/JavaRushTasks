package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument() {
        return document;
    }

    public Controller(View view) {
        this.view = view;
    }
    public static void main(String[] args){
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }
    public void init(){
        createNewDocument();
    }
    public void exit(){
        System.exit(0);
    }
    public void resetDocument(){
        if (document != null){
            document.removeUndoableEditListener(view.getUndoListener());
        }
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.read(reader,document,0);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
    public String getPlainText(){
        StringWriter writer = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(writer,document,0, document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
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
        JFileChooser jFileChooser = new JFileChooser();
        HTMLFileFilter htmlFileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(htmlFileFilter);
        int w = jFileChooser.showOpenDialog(view);
        if (w == JFileChooser.APPROVE_OPTION){
            view.resetUndo();
            resetDocument();
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileReader reader = new FileReader(currentFile);
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.read(reader,document,0);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }

    }
    public void saveDocument(){
        if (currentFile != null){
            view.selectHtmlTab();
            try {
                FileWriter writer = new FileWriter(currentFile);
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.write(writer, document, 0, document.getLength());
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }else {
            saveDocumentAs();
        }
    }
    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        HTMLFileFilter htmlFileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(htmlFileFilter);
        int w = jFileChooser.showSaveDialog(view);
        if (w == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter writer = new FileWriter(currentFile);
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.write(writer,document,0,document.getLength());
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
