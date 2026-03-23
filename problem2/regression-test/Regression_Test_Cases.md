# Regression Test Cases - E-Wallet Mobile App

This document outlines the regression test suite designed to verify recent bug fixes and maintain cross-feature stability.

---

## **1. Verification of Recent Fixes**

### **RT-01: Verify Fix for Credit Card Double Charge**
- **Scenario:** Perform a single top-up via credit card and verify only one charge occurs.
- **Steps:** 
  1. Select "Top-up" -> "Credit Card".
  2. Enter $50 and valid card details.
  3. Click "Pay" exactly **once**.
  4. Wait for the success screen.
- **Verification:** 
  - Wallet balance should be exactly `Old Balance + $50`.
  - Check **Transaction History** for only one $50 record.
  - (Internal) Check backend logs for only one successful request to the payment gateway.

### **RT-02: Verify Fix for Incorrect Balance Display**
- **Scenario:** Perform a money transfer and verify the balance is updated correctly across all UI screens.
- **Steps:**
  1. Note the current home balance (e.g., $100).
  2. Perform "Send Money" for $20 to a valid phone number.
  3. Immediately check the balance on the **Home Screen**.
  4. Navigate to the **"Send Money"** screen again and check the "Available Balance" field.
- **Verification:** 
  - Both screens should consistently display the updated balance (e.g., $80).
  - No "ghost balance" or delay in UI synchronization.

---

## **2. Stability & Impact Analysis**

### **RT-03: Verify Cross-Feature Stability (Limits & Bill Payments)**
- **Scenario:** Ensure top-up/transfer fixes didn't break Transaction Limits or Bill Payment logic.
- **Steps:**
  1. Verify the user's daily transaction limit (e.g., $500).
  2. Pay an electricity bill for $50 via the "Bill Payment" feature.
  3. Attempt to send $600 to another user (exceeding the limit).
- **Verification:** 
  - **Bill Payment:** Succeeds, balance is deducted correctly, and history shows the record.
  - **Daily Limits:** System correctly blocks the $600 transfer with an "Exceeds daily limit" error.
  - **Integrity:** Confirms that the balance update fix also applies correctly to Bill Payment flows.
