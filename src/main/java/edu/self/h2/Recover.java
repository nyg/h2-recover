package edu.self.h2;

import org.h2.mvstore.MVMap;
import org.h2.mvstore.MVStore;

public class Recover {

    /**
     * http://stackoverflow.com/a/35571906/5536516
     */
    public static void main(String[] args) {

        // open the store (in-memory if fileName is null)
        final MVStore store = MVStore.open(args[0]);

        final MVMap<Object, Object> openMap = store.openMap("undoLog");
        openMap.clear();

        // close the store (this will persist changes)
        store.close();
    }
}
