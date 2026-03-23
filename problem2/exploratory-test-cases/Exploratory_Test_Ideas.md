# Exploratory Testing Ideas - Wallet Top-up

This document outlines 3 unusual scenarios identified during exploratory testing of the Wallet Top-up feature.

---

### **1. Mid-Transaction Network Handover**
- **Scenario:** Initiate a top-up via a linked bank account on **Wi-Fi**. While the 3D Secure authentication page is loading, manually disable Wi-Fi to force the device onto **4G/5G mobile data**.
- **Objective:** Verify if the app maintains the session state and correctly processes the transaction callback despite the change in IP address and network interface.
- **Risk:** Session timeout or transaction failure due to lost handshake.

### **2. Double-Click Race Condition**
- **Scenario:** Rapidly and simultaneously tap the "Confirm Top-up" button multiple times using two fingers.
- **Objective:** Check if the UI/API implements proper debouncing or idempotency to prevent the user from being charged twice for a single top-up intent.
- **Risk:** Duplicate charges on the user's bank account/credit card.

### **3. OS-Level Interruption during Finalization**
- **Scenario:** At the exact moment the user taps "Confirm," trigger a system-level interrupt such as an incoming phone call or a "Low Battery" alert. Accept the call, then return to the app to check the transaction status.
- **Objective:** Ensure the transaction atomicity is maintained. The app should either show the success/fail screen or correctly reflect the updated balance in the history without hanging.
- **Risk:** App crash or balance update failure without user notification.
