import React from 'react'
import Header from '../../components/Header'
import { useState } from 'react'
import DrugService from '../api/DrugService'
import { Button } from '@mui/material'
import Link from 'next/link'
import DrugCreation from '../../components/DrugCreation'
import drugImage from '../../assets/drug.svg'
import Image from 'next/image'
export async function getStaticProps() {
   try {
      const response = await DrugService.getDrugs()

      const data = await response.json()
      return {
         props: {
            drugs: data
         }
      }
   } catch (error) {
      return {
         props: {
            drugs: { drugCategoryId: "error", drugName: error, drugPrice: "error" }
         }
      }
   }
}

function drugstore({ drugs }) {
   return (
      <>
         <Header />
         <div className="flex flex-col mt-10 items-center justify-center w-full">
            <DrugCreation />
         </div>
         <section className="text-gray-600 body-font">
            <div className="container px-5 mt-5 mx-auto">
               <div className="flex flex-wrap mx-10 gap-8">

                  {drugs.map((drug) => (

                     <Link href={`/drugstore/${drug.drugId}`}>
                        <div key={drug.drugId} className="max-w-sm cursor-pointer border-pink-200 bg-white border-2 rounded-lg shadow-md dark:bg-gray-800 dark:border-gray-700 ">

                           <Image
                              alt="drugImage"
                              src={drugImage}
                              layout="responsive"
                              width={130}
                              height={70}
                           />

                           <div className="px-5 pb-5 flex flex-col gap-4">
                              <Link href={`/drugstore/${drug.drugId}`}>
                                 <h5 className="text-xl font-semibold tracking-tight text-gray-900 dark:text-white">{drug.drugName}</h5>
                              </Link>
                              <div className="flex justify-between gap-10 items-center">
                                 <p className="text-gray-600 dark:text-gray-400">{drug.drugQuantity}💊</p>
                                 <p className="text-gray-600 dark:text-gray-400">{drug.drugStock}📦</p>
                              </div>
                              <div className="flex justify-between gap-10 items-center">
                                 <span className=" text-2xl font-bold text-gray-900 dark:text-white">{drug.drugPrice}DH</span>
                                 <a href="#" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Add to cart</a>
                              </div>
                           </div>
                        </div>
                     </Link>

                  ))}
               </div>
            </div>
            <div>

            </div>
         </section>

      </>
   )
}
export default drugstore