import { useEffect } from 'react'
import Header from '../components/Header'
import Hero from '../components/Hero'
import toast, { Toaster } from 'react-hot-toast'
import { getAuth, signInWithPopup, GoogleAuthProvider } from "firebase/auth";
import { app } from '../components/firebase.config';
import MainPage from '../components/MainPage'

const style = {
  wrapper: ``,
  walletConnectWrapper: `flex flex-col justify-center items-center h-screen w-screen bg-[#3b3d42] `,
  button: `border border-[#282b2f] bg-[#2081e2] p-[0.8rem] text-xl font-semibold rounded-lg cursor-pointer text-black`,
  details: `text-lg text-center text=[#282b2f] font-semibold mt-4`,
}

export default function Home() {

  const auth = getAuth(app);
  const user = auth.currentUser;


  const welcomeUser = (userName, toastHandler = toast) => {
    toastHandler.success(
      `Welcome back ${userName != 'Unnamed' ? `${userName}` : ''} !`,
      {
        style: {
          background: '#04111d',
          color: '#fff',
        }
      }
    )
  }



  useEffect(() => {
    if (!user) return
      ; (async () => {

        const userName = await user.displayName

        welcomeUser(userName)
      })()

  }, [user]);

  return (
    <div className={style.wrapper}>
      <Toaster
        position="bottom-center"
        reverseOrder={false}
      />



      <Header />
      <MainPage />


    </div>
  )
}


