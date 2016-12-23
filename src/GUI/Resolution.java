package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Resolution{
    
    private static final String RESOLUTION_FRAME_TITLE= "Choose preffered resolution for application";
    
    private final int width;
    private final int height;
    
    public Resolution(int width, int height){
        this.width=width;
        this.height=height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public static void askForResolutionIfNotChosen(boolean isChosen){
        final JFrame resolutionChooser = new JFrame(RESOLUTION_FRAME_TITLE);
        
        //setting main preferences
        resolutionChooser.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        resolutionChooser.setSize(new Dimension(175,125));
        resolutionChooser.setResizable(false);
        resolutionChooser.setLocation(300, 200);
        //add components
        JPanel mainPanel = mainPanelForResolutionChoosing(resolutionChooser);
        resolutionChooser.add(mainPanel);
        resolutionChooser.setVisible(true);
    }
    
    public static JPanel mainPanelForResolutionChoosing(final JFrame whatToClose){
        JPanel main = new JPanel();
        main.setLayout(null);
        //adding components
        JLabel text = new JLabel("Choose resolution");
        main.add(text);
        JComboBox chooser = createComboBox();
        main.add(chooser);
        JButton closer=createClosingButton(whatToClose, chooser);
        main.add(closer);
        //setting layout
        Dimension text_size = text.getPreferredSize();
        Dimension chooser_size = chooser.getPreferredSize();
        Dimension button_size = closer.getPreferredSize();
        int topGap = (125-text_size.height-chooser_size.height-button_size.height)/4;
        text.setBounds((175-text_size.width)/2, topGap, text_size.width, text_size.height);
        chooser.setBounds((175-chooser_size.width)/2, topGap+text_size.height, chooser_size.width, chooser_size.height);
        closer.setBounds((175-button_size.width)/2, topGap+text_size.height+chooser_size.height, button_size.width, button_size.height);
        //return statement
        return main;
    }
    
    public static JButton createClosingButton(final JFrame windowToClose, final JComboBox comboBox){
        JButton closingButton = new JButton("OK");
        closingButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String whatIsSelected = (String)comboBox.getSelectedItem();
                int width = (int) Integer.parseInt(whatIsSelected.substring(0,whatIsSelected.indexOf("x")-1));
                int height = (int) Integer.parseInt(whatIsSelected.substring(whatIsSelected.indexOf("x")+2, whatIsSelected.length()));
                File properties = new File("properties.txt");
                try {
                    if(properties.createNewFile()){
                        PrintWriter writer = new PrintWriter(properties);
                        writer.println(width);
                        writer.println(height);
                        writer.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getClass().toString()+" while creating properties file");
                }
                windowToClose.setVisible(false);
                MainFrame.runGUI(width, height);
            }
        });
        return closingButton;
    }
    
    private static JComboBox createComboBox(){
        String[] whatUserCanChooseFromComboBox = new String[]{"640 x 480", "800 x 600", "1024 x 800", "1280 x 1024"};
        JComboBox comboBox = new JComboBox(whatUserCanChooseFromComboBox);
        comboBox.setVisible(true);
        comboBox.setSelectedIndex(0);
        return comboBox;
    }
}
