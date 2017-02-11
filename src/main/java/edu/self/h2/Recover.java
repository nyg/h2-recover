package edu.self.h2;

import org.h2.mvstore.MVStore;

public class Recover {

    /**
     * http://stackoverflow.com/a/35571906/5536516
     */
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Path of H2 database file required!");
            System.exit(1);
        }

        // open the store (in-memory if fileName is null)
        MVStore store = MVStore.open(args[0]);
        store.openMap("undoLog").clear();

        // close the store (this will persist changes)
        store.close();
        System.out.println("Done!");
    }
}
