package com.pluralsight;

//? BigDecimal = exact money math (double can lose pennies)
import java.math.BigDecimal;

//* Cash IS-A Asset (child class): money stashed under the mattress
//* It has no extra fields of its own, everything it needs comes from Asset
public class Cash extends Asset {

    //* Constructor: only 3 values, and all of them go UP to Asset
    //! Needed because Asset has no empty constructor (same super rule as House and Vehicle)
    public Cash(String description, String dateAcquired, BigDecimal originalCost) {
        super(description, dateAcquired, originalCost);
    }

    //! REQUIRED: Asset's getValue() is abstract, so Cash must write its own
    //? Without it: "Cash is not abstract and does not override abstract method getValue()"
    //* Cash never changes value, so it's worth exactly what you put in
    //! originalCost is private in Asset, so we use the inherited getter
    @Override
    public BigDecimal getValue() {
        return getOriginalCost();
    }
}
