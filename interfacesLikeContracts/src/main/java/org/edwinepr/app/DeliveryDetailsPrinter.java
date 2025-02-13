package org.edwinepr.app;

import org.edwinepr.interfaces.Sorter;

public class DeliveryDetailsPrinter {

    Sorter sorter;

    public DeliveryDetailsPrinter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void printDetails() {
        sorter.sortDetails();
        // print the delivery details
    }
}
