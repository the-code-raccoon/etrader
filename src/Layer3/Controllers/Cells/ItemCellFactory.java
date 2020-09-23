package Layer3.Controllers.Cells;

import Layer1.Entities.Item;
import Layer1.Enums.CellType;
import Layer3.Repos.*;
import Layer3.Repos.JavaKeyStore.JavaKeyStoreRepo;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * A cell Factory that intakes Items
 */
public class ItemCellFactory extends AbstractCellFactory<Item> {

    private final CellType cellType;

    /**
     * constructs a ListCellFactory for Items
     *
     * @param buRepo    a basic user repo object responsible for reading and writing BasicUsers objects to a file.
     * @param auRepo    an admin user repo object responsible for reading and writing adminUsers objects to a file.
     * @param iRepo     an item repo object responsible for reading and writing items objects to a file.
     * @param tRepo     a transaction repo object responsible for reading and writing transactions objects to a file.
     * @param anRepo    an admin notification repo object responsible for reading and writing admin notifications
     *                  objects to a file.
     * @param imageRepo an image repo object responsible for reading and writing images objects to a file.
     * @param duRepo    a demo user repo object responsible for reading and writing demoUsers objects to a file.
     * @param jksRepo   JavaKeyStore repository responsible for reading and writing Java key-stores to a file.
     * @param cellType  an enum representing a type of Cell
     */
    public ItemCellFactory(BasicUserRepo buRepo, AdminUserRepo auRepo, ItemsRepo iRepo,
                           TransactionsRepo tRepo, AdminNotificationRepo anRepo, ImageRepo imageRepo,
                           DemoUserRepo duRepo, JavaKeyStoreRepo jksRepo, CellType cellType){
        super(buRepo, auRepo, iRepo, tRepo, anRepo, imageRepo, duRepo, jksRepo);

        this.cellType = cellType;
    }

    /**
     * overrides call method that searches for the format so a custom Item listCell can be used
     * @param param represents the Item ListView type
     */
    @Override
    public ListCell<Item> call(ListView<Item> param) {
        return new ItemCell(buRepo, auRepo, iRepo, tRepo, anRepo, imageRepo, duRepo, jksRepo, cellType);
    }
}
