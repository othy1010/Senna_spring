import React from 'react'
import { HiOutlineArrowNarrowRight } from 'react-icons/hi'
import Image from 'next/image'
import { useRouter } from 'next/router'
import HeroImage from '../assets/home.svg'


function MainPage() {
   const router = useRouter()
   const redirct = () => {

      router.push('/drugstore')
   }
   return (
      <>
         <div className=" w-screen">
            <div className="flex h-auto w-screen items-center justify-center p-8">
               <div className="ml-10 md:ml-20 md:w-1/2">
                  <h1 className="my-5 text-5xl font-bold text-gray-800 md:text-7xl">
                     Welcome to Senna
                  </h1>
                  <p className="text-base text-gray-500 md:text-xl">
                     Your Online pharmacy from the palm of your hand
                  </p>
                  <div className="mt-12 flex items-start justify-start gap-5 text-center ">
                     <button onClick={redirct}
                        className=" h-14  cursor-pointer rounded-xl  bg-violet-600 px-8 font-semibold text-white hover:bg-violet-900 hover:shadow-xl">
                        Drug Store
                     </button>
                     <button className="h-14 cursor-pointer rounded-xl  border border-violet-600 px-8 font-semibold text-violet-600 hover:bg-violet-900 hover:text-white hover:shadow-xl" >
                        About us
                     </button>
                  </div>
               </div>

               <div className="hidden md:block">
                  <Image
                     src={HeroImage}
                     width={900}
                     height={700}
                     objectFit="contain"
                     alt="hero img"
                  />
               </div>
            </div>

         </div>
      </>
   )
}

export default MainPage