package arithmeticchallengegame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Utilities {

    public static JLabel LocateLabel(Container container, SpringLayout myLabelLayout, String labelCaption, int x, int y, Color foreColor) {
        JLabel myLabel = new JLabel(labelCaption);
        container.add(myLabel);
        myLabel.setForeground(foreColor);
        myLabelLayout.putConstraint(SpringLayout.WEST, myLabel, x, SpringLayout.WEST, container);
        myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, container);
        return myLabel;
    }

    public static JLabel LocateLabel(Container container, SpringLayout myLabelLayout, String labelCaption, int x, int y) {
        return LocateLabel(container, myLabelLayout, labelCaption, x, y, Color.black);
    }

    public static JButton LocateButton(JFrame frame, SpringLayout myButtonLayout, String btnCaption, boolean isEnabled, int x, int y, int w, int h, int keyPress) {
        JButton myButton = new JButton(btnCaption);
        frame.add(myButton);
        myButton.setEnabled(isEnabled);
        myButton.setMnemonic(keyPress);
        myButton.setPreferredSize(new Dimension(w, h)); // sets the dimensions
        myButtonLayout.putConstraint(SpringLayout.WEST, myButton, x, SpringLayout.WEST, frame);
        myButtonLayout.putConstraint(SpringLayout.NORTH, myButton, y, SpringLayout.NORTH, frame);
        myButton.setMargin(new Insets(0, 0, 0, 0)); // removes the button margins so smaller sizes won't cut the text off
        myButton.addActionListener((ActionListener) frame);
        return myButton;
    }

    public static JButton LocateButton(JFrame frame, SpringLayout myButtonLayout, String btnCaption, boolean isEnabled, int x, int y, int w, int h) {
        return LocateButton(frame, myButtonLayout, btnCaption, isEnabled, x, y, w, h, 0);
    }

    public static JButton LocateButton(JFrame frame, SpringLayout myButtonLayout, String btnCaption, int x, int y, int w, int h, int keyPress) {
        return LocateButton(frame, myButtonLayout, btnCaption, true, x, y, w, h, keyPress);
    }

    public static JButton LocateButton(JFrame frame, SpringLayout myBtnLayout, String btnCaption, int x, int y, int w, int h) {
        return LocateButton(frame, myBtnLayout, btnCaption, true, x, y, w, h, 0);
    }

    public static JTextField LocateTextField(JFrame frame, SpringLayout myTextFieldLayout, String defaultText, int x, int y, int w, boolean isEditable) {
        JTextField myTextField = new JTextField(defaultText, w);
        frame.add(myTextField);
        myTextFieldLayout.putConstraint(SpringLayout.WEST, myTextField, x, SpringLayout.WEST, frame);
        myTextFieldLayout.putConstraint(SpringLayout.NORTH, myTextField, y, SpringLayout.NORTH, frame);
        myTextField.setEditable(isEditable);
        return myTextField;
    }

    public static JTextArea LocateTextArea(JFrame frame, SpringLayout myTextAreaLayout, String defaultText, int x, int y, int w, int h) {
        JTextArea myTextArea = new JTextArea(defaultText);
        myTextArea.setLineWrap(true);
        myTextArea.setWrapStyleWord(true);
        myTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane sp = new JScrollPane(myTextArea);
        // in order for the scrollpane to work, the preferred size has to bet set on the scrollpane, not the textarea
        sp.setPreferredSize(new Dimension(w, h));
        frame.add(sp);
        myTextAreaLayout.putConstraint(SpringLayout.WEST, sp, x, SpringLayout.WEST, frame);
        myTextAreaLayout.putConstraint(SpringLayout.NORTH, sp, y, SpringLayout.NORTH, frame);
        return myTextArea;
    }

    public static JComboBox LocateComboBox(JFrame frame, SpringLayout myComboBoxLayout, String[] items, int x, int y) {
        JComboBox myComboBox = new JComboBox(items);
        frame.add(myComboBox);
        myComboBoxLayout.putConstraint(SpringLayout.WEST, myComboBox, x, SpringLayout.WEST, frame);
        myComboBoxLayout.putConstraint(SpringLayout.NORTH, myComboBox, y, SpringLayout.NORTH, frame);
        return myComboBox;
    }

    public static JSpinner LocateJSpinner(JFrame f, SpringLayout myJSpinnerLayout, int x, int y, int w) {
        JSpinner myJSpinner = new JSpinner();
        f.add(myJSpinner);
        myJSpinnerLayout.putConstraint(SpringLayout.WEST, myJSpinner, x, SpringLayout.WEST, f);
        myJSpinnerLayout.putConstraint(SpringLayout.NORTH, myJSpinner, y, SpringLayout.NORTH, f);
        myJSpinner.setPreferredSize(new Dimension(w, 25));
        return myJSpinner;
    }

    public static JRadioButton LocateJRadioButton(JFrame f, SpringLayout myRadioButtonLayout, String caption, int x, int y, boolean selected) {
        JRadioButton myRdoBtn = new JRadioButton(caption);
        f.add(myRdoBtn);
        myRadioButtonLayout.putConstraint(SpringLayout.WEST, myRdoBtn, x, SpringLayout.WEST, f);
        myRadioButtonLayout.putConstraint(SpringLayout.NORTH, myRdoBtn, y, SpringLayout.NORTH, f);
        myRdoBtn.setSelected(selected);
        myRdoBtn.addActionListener((ActionListener) f);
        return myRdoBtn;
    }

    public static boolean isAnswerCorrect(int submittedAns, int correctAns) {
        return submittedAns == correctAns;
    }

    public static int getAnswer(int num1, char op, int num2) {
        int ans = 0;
        switch(op) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/':
                ans = num1 / num2;
                break;
        }
        return ans;
    }

    /**
     * Converts an object directory to an integer
     * @param obj The object to convert
     * @return The integer
     */
    public static int convertObjToInt(Object obj) {
        return Integer.parseInt(obj.toString());
    }
    
}
