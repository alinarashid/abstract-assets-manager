package com.pluralsight;

//? BigDecimal = exact money math (double can lose pennies)
import java.math.BigDecimal;

//* Asset = the PARENT class: anything you own that's worth money
//* House, Vehicle and Cash extend this, so they inherit everything here
//! ABSTRACT = just a category: you can't write new Asset(...), only new House/Vehicle/Cash
//? Like "fruit": you can't buy "a fruit", only an apple or a banana
public abstract class Asset {

    //* Shared fields every asset has
    //! private = only Asset can touch these directly; children use the getters/setters
    private String description;
    private String dateAcquired;
    private BigDecimal originalCost;

    //* Constructor: fills in the 3 shared fields
    //! Children MUST call this with super(description, dateAcquired, originalCost)
    public Asset(String description, String dateAcquired, BigDecimal originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    //* Getters: inherited by House, Vehicle and Cash (they don't need to rewrite these)
    public String getDescription() {
        return description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    //* Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

    //! ABSTRACT METHOD: a promise with no body (ends with ; not { })
    //! Every child MUST write its own getValue(), or Java won't compile
    //? No body because Asset doesn't know HOW: a house, a car and cash are each valued differently
    public abstract BigDecimal getValue();
}
