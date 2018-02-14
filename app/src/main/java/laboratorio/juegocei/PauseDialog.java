package laboratorio.juegocei;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Moren on 13/2/2018.
 */

public class PauseDialog extends android.support.v4.app.DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            String[] options = {"activado", "desactivado"};
            int checkedItem = 1; // cow
            builder.setTitle(R.string.dialog_pause_text)
                    .setSingleChoiceItems(options, checkedItem, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // user checked an item
                }
            }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //TODO do something
                }
            });
            // Create the AlertDialog object and return it
            return builder.create();
        }
}
