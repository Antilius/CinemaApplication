package GUI.Buttons;

import GUI.Admin.InputDialogs.DialogPattern;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonShowingDialog extends JButton implements ActionListener{
    
    private DialogPattern dialog;
    
    public ButtonShowingDialog(int text_size, DialogPattern dialog){
        super(dialog.getTitle());
        this.dialog = dialog;
        this.setFont(new Font("Times Roman",Font.PLAIN,text_size));
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this){
            this.dialog.setVisible(true);
        }
    }
    
}
