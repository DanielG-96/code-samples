import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * An assortment of utilities for use in a Java program, mainly on component creation.
 *
 * @author Daniel Geurts
 */
public class Utilities {

    /**
     * Creates a JLabel with the ability to set a colour
     *
     * @param frame         JFrame to attach to
     * @param myLabelLayout Layout to place on
     * @param labelCaption  Caption of the label
     * @param x             X position
     * @param y             Y position
     * @param foreColor     Colour of the label
     * @return JLabel
     */
    public static JLabel CreateJLabel(JFrame frame, SpringLayout myLabelLayout, String labelCaption, int x, int y, Color foreColor) {
        JLabel myLabel = new JLabel(labelCaption);
        frame.add(myLabel);
        myLabel.setForeground(foreColor);
        myLabelLayout.putConstraint(SpringLayout.WEST, myLabel, x, SpringLayout.WEST, frame);
        myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, frame);
        return myLabel;
    }

    /**
     * Creates a JLabel with the default color (black)
     *
     * @param frame         JFrame to attach to
     * @param myLabelLayout Layout to place on
     * @param labelCaption  Caption of the label
     * @param x             X position
     * @param y             Y position
     * @return JLabel
     */
    public static JLabel CreateJLabel(JFrame frame, SpringLayout myLabelLayout, String labelCaption, int x, int y) {
        return CreateJLabel(frame, myLabelLayout, labelCaption, x, y, Color.black);
    }

    /**
     * Creates a JButton with the ability to set its enabled state and the key press event
     *
     * @param frame          JFrame to attach to
     * @param myButtonLayout Layout to place on
     * @param btnCaption     Caption of the button
     * @param isEnabled      Enabled or disabled by default
     * @param x              X position
     * @param y              Y position
     * @param w              Button Width
     * @param h              Button Height
     * @param keyPress       Key press
     * @return JButton
     */
    public static JButton CreateJButton(JFrame frame, SpringLayout myButtonLayout, String btnCaption, boolean isEnabled, int x, int y, int w, int h, int keyPress) {
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

    /**
     * Creates a JButton with the ability to set its enabled state
     *
     * @param frame          JFrame to attach to
     * @param myButtonLayout Layout to place on
     * @param btnCaption     Caption of the button
     * @param isEnabled      Enabled or disabled by default
     * @param x              X position
     * @param y              Y position
     * @param w              Button Width
     * @param h              Button Height
     * @return JButton
     */
    public static JButton CreateJButton(JFrame frame, SpringLayout myButtonLayout, String btnCaption, boolean isEnabled, int x, int y, int w, int h) {
        return CreateJButton(frame, myButtonLayout, btnCaption, isEnabled, x, y, w, h, 0);
    }

    /**
     * Creates a JButton with the ability to set a key press
     *
     * @param frame          JFrame to attach to
     * @param myButtonLayout Layout to place on
     * @param btnCaption     Caption of the button
     * @param x              X position
     * @param y              Y position
     * @param w              Button Width
     * @param h              Button Height
     * @param keyPress       Key press
     * @return JButton
     */
    public static JButton CreateJButton(JFrame frame, SpringLayout myButtonLayout, String btnCaption, int x, int y, int w, int h, int keyPress) {
        return CreateJButton(frame, myButtonLayout, btnCaption, true, x, y, w, h, keyPress);
    }

    /**
     * Creates a JButton
     *
     * @param frame       JFrame to attach to
     * @param myBtnLayout Layout to place on
     * @param btnCaption  Caption of the button
     * @param x           X position
     * @param y           Y position
     * @param w           Button Width
     * @param h           Button Height
     * @return JButton
     */
    public static JButton CreateJButton(JFrame frame, SpringLayout myBtnLayout, String btnCaption, int x, int y, int w, int h) {
        return CreateJButton(frame, myBtnLayout, btnCaption, true, x, y, w, h, 0);
    }

    /**
     * Creates a JTextField with the ability to set its enabled state
     * @param frame JFrame to attach to
     * @param myTextFieldLayout Layout to place on
     * @param defaultText Default text when component is created
     * @param x X position
     * @param y Y position
     * @param w Text field width
     * @param isEditable Can be edited
     * @return JTextField
     */
    public static JTextField LocateTextField(JFrame frame, SpringLayout myTextFieldLayout, String defaultText, int x, int y, int w, boolean isEditable) {
        JTextField myTextField = new JTextField(defaultText, w);
        frame.add(myTextField);
        myTextFieldLayout.putConstraint(SpringLayout.WEST, myTextField, x, SpringLayout.WEST, frame);
        myTextFieldLayout.putConstraint(SpringLayout.NORTH, myTextField, y, SpringLayout.NORTH, frame);
        myTextField.setEditable(isEditable);
        return myTextField;
    }

    /**
     * Creates a JTextArea
     * @param frame JFrame to attach to
     * @param myTextAreaLayout Layout to place on
     * @param defaultText Default text when component is created
     * @param x X position
     * @param y Y position
     * @param w Text area width
     * @param h Text area height
     * @return JTextArea
     */
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

    /**
     * Creates a JComboBox containing an array of strings
     * @param frame JFrame to attach to
     * @param myComboBoxLayout Layout to place on
     * @param items Array of items to be bound in field
     * @param x X position
     * @param y Y position
     * @return JComboBox
     */
    public static JComboBox LocateComboBox(JFrame frame, SpringLayout myComboBoxLayout, String[] items, int x, int y) {
        JComboBox<String> myComboBox = new JComboBox<>(items);
        frame.add(myComboBox);
        myComboBoxLayout.putConstraint(SpringLayout.WEST, myComboBox, x, SpringLayout.WEST, frame);
        myComboBoxLayout.putConstraint(SpringLayout.NORTH, myComboBox, y, SpringLayout.NORTH, frame);
        return myComboBox;
    }

    /**
     * Creates a JComboBox containing an array of objects
     *
     * @param frame  JFrame to attach to
     * @param layout Layout to place on
     * @param items  Array of items to be bound in field
     * @param x      X position
     * @param y      Y position
     * @return JComboBox
     */
    public static JComboBox LocateComboBox(JFrame frame, SpringLayout layout, Object[] items, int x, int y) {
        JComboBox<Object> comboBox = new JComboBox<>(items);
        frame.add(comboBox);
        layout.putConstraint(SpringLayout.WEST, comboBox, x, SpringLayout.WEST, frame);
        layout.putConstraint(SpringLayout.NORTH, comboBox, y, SpringLayout.NORTH, frame);
        return comboBox;
    }

    /**
     * Creates a JSpinner (numeric up-down)
     * @param frame JFrame to attach to
     * @param myJSpinnerLayout Layout to place on
     * @param x X position
     * @param y Y position
     * @param w JSpinner Width
     * @return JSpinner
     */
    public static JSpinner LocateJSpinner(JFrame frame, SpringLayout myJSpinnerLayout, int x, int y, int w) {
        JSpinner myJSpinner = new JSpinner();
        frame.add(myJSpinner);
        myJSpinnerLayout.putConstraint(SpringLayout.WEST, myJSpinner, x, SpringLayout.WEST, frame);
        myJSpinnerLayout.putConstraint(SpringLayout.NORTH, myJSpinner, y, SpringLayout.NORTH, frame);
        myJSpinner.setPreferredSize(new Dimension(w, 25));
        return myJSpinner;
    }

    /**
     * Creates a JRadioButton
     *
     * @param frame               JFrame to attach to
     * @param myRadioButtonLayout Layout to place on
     * @param caption             Caption of the radio button
     * @param x                   X position
     * @param y                   Y position
     * @param selected            Default selection state
     * @return JRadioButton
     */
    public static JRadioButton LocateJRadioButton(JFrame frame, SpringLayout myRadioButtonLayout, String caption, int x, int y, boolean selected) {
        JRadioButton myRdoBtn = new JRadioButton(caption);
        frame.add(myRdoBtn);
        myRadioButtonLayout.putConstraint(SpringLayout.WEST, myRdoBtn, x, SpringLayout.WEST, frame);
        myRadioButtonLayout.putConstraint(SpringLayout.NORTH, myRdoBtn, y, SpringLayout.NORTH, frame);
        myRdoBtn.setSelected(selected);
        myRdoBtn.addActionListener((ActionListener) frame);
        return myRdoBtn;
    }

    /**
     * Converts an object to an integer
     * @param obj The object to convert
     * @return The integer
     */
    public static int convertObjToInt(Object obj) {
        return Integer.parseInt(obj.toString());
    }
    
}
