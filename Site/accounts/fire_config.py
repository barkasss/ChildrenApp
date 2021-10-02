import pyrebase

config = {
  "apiKey": "AIzaSyCCG8SHpeVWz0OT5ovGEhtxH9UXFH_sMGc",
  "authDomain": "childrenapp-4aba1.firebaseapp.com",
  "databaseURL": "https://childrenapp-4aba1-default-rtdb.europe-west1.firebasedatabase.app",
  "storageBucket": "childrenapp-4aba1.appspot.com"
}

firebase = pyrebase.initialize_app(config)

auth = firebase.auth()
db = firebase.database()

