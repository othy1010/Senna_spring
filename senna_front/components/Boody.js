
import React from 'react'
import homeImage from '../assets/home.svg'
import Image from 'next/image'

const style = {
   wrapper: `relative`,
   container: `before:content-[''] before:bg-red-500 before:absolute before:top-0 before:left-0 before:right-0 before:bottom-0 before:bg-cover before:bg-center before:opacity-30 `,
   contentWrapper: `flex h-screen relative justify-center flex-wrap items-center`,
   copyContainer: `w-1/2`,
   title: `relative text-white text-[46px] font-semibold`,
   description: `text-[#8a939b] container-[400px] text-2xl mt-[0.8rem] mb-[2.5rem]`,
   ctaContainer: `flex`,
   accentedButton: ` relative text-lg font-semibold px-12 py-4 bg-[#2181e2] rounded-lg mr-5 text-white hover:bg-[#42a0ff] cursor-pointer`,
   button: ` relative text-lg font-semibold px-12 py-4 bg-[#363840] rounded-lg mr-5 text-[#e4e8ea] hover:bg-[#4c505c] cursor-pointer`,
   cardContainer: `rounded-[3rem]`,
   infoContainer: `h-20 bg-[#313338] p-4 rounded-b-lg flex items-center text-white`,
   author: `flex flex-col justify-center ml-4`,
   name: ``,
   infoIcon: `flex justify-end items-center flex-1 text-[#8a939b] text-3xl font-bold`,
}

const Hero = () => {
   return (
      <div className={style.wrapper}>
         <div className={style.container}>
            <div className={style.contentWrapper}>
               <div className={style.copyContainer}>
                  <div className={style.title}>
                     Your Online pharmacy
                  </div>
                  <div className={style.description}>
                     From the palm of your hand
                  </div>
                  <div className={style.ctaContainer}>
                     <button className={style.accentedButton}>Drug-store</button>
                     <button className={style.button}>learn more</button>
                  </div>
               </div>
               <div className={style.cardContainer}>
                  <Image src={homeImage} className="rounded-t-lg" />
                  <div className={style.infoContainer}>

                     <div className={style.author}>
                        <div className={style.name}>Jolly</div>
                        <a
                           className="text-[#1868b7]"
                           src={homeImage}
                        >
                           hola-kanola
                        </a>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   )
}

export default Hero



