package eu.fthevenet.binjr.sources.jrds.adapters;

import eu.fthevenet.binjr.data.adapters.DataAdapter;
import eu.fthevenet.util.ui.dialogs.DataAdapterDialog;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.net.MalformedURLException;
import java.time.DateTimeException;
import java.time.ZoneId;


/**
 * Created by FTT2 on 01/03/2017.
 */
public class JrdsAdapterDialog extends DataAdapterDialog {

   private final ChoiceBox<JrdsTreeFilter> tabsChoiceBox;
    /**
     * Initializes a new instance of the {@link JrdsAdapterDialog} class.
     *
     * @param owner the owner window for the dialog
     */
    public JrdsAdapterDialog(Node owner) {
        super(owner);
        this.parent.setHeaderText("Connect to a JRDS source");
        this.tabsChoiceBox = new ChoiceBox<>();
        tabsChoiceBox.getItems().addAll(JrdsTreeFilter.values());
        GridPane.setConstraints(tabsChoiceBox, 1,2,1,1, HPos.LEFT, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(4,0,4,0));
        tabsChoiceBox.getSelectionModel().select(JrdsTreeFilter.HOSTS_TAB);
        Label tabsLabel = new Label("Tree View:");
        GridPane.setConstraints(tabsLabel, 0,2,1,1, HPos.LEFT, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(4,0,4,0));
        this.paramsGridPane.getChildren().addAll(tabsLabel, tabsChoiceBox);
    }

    @Override
    protected DataAdapter getDataAdapter() throws MalformedURLException, DateTimeException {
          return JrdsDataAdapter.fromUrl(
                  this.urlField.getText(),
                  ZoneId.of(this.timezoneField.getText()),
                  this.tabsChoiceBox.getValue());
    }
}
