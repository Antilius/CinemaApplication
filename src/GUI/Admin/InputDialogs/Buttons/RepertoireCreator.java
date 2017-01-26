package GUI.Admin.InputDialogs.Buttons;

import GUI.Admin.InputDialogs.CreateRepertoireForDate;
import GUI.Admin.InputDialogs.DialogPattern;
import GUI.Buttons.ButtonShowingDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepertoireCreator extends ButtonShowingDialog implements ActionListener{

    public RepertoireCreator(DialogPattern dialog) {
        super(12,dialog);
    }    
    
}
