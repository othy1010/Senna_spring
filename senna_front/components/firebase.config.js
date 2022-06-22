import { getApp, getApps, initializeApp } from '@firebase/app';
import { getFirestore } from "firebase/firestore";
import { getStorage } from "firebase/storage";


const firebaseConfig = {
   apiKey: "AIzaSyCv58te4Qmhq7KCh5MtydFvB3JicoR4jKI",
   authDomain: "senna-2022.firebaseapp.com",
   databaseURL: "https://senna-2022-default-rtdb.europe-west1.firebasedatabase.app",
   projectId: "senna-2022",
   storageBucket: "senna-2022.appspot.com",
   messagingSenderId: "1028307038263",
   appId: "1:1028307038263:web:96ea7c3297f1ba60004fb2",
   measurementId: "G-H7YDJ8E102"
};

// Initialize Firebase
const app = getApps.length > 0 ? getApps() : initializeApp(firebaseConfig);
const firestore = getFirestore(app);
const storage = getStorage(app);

export { app, firestore, storage }
// const analytics = getAnalytics(app);