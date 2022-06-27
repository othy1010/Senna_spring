import React from 'react'
import Header from '../components/Header'
import { useState } from 'react'
import DrugService from './api/DrugService'
import { Button } from '@mui/material'

export async function getStaticProps() {
   const bk_url = process.env.BACKEND_URL
   console.log(bk_url, "bk_url")


   try {

      const data = await DrugService.getDrugs()
      // const data = await response.json()
      // console.log(data, "data")
      console.log(DrugService.getDrugs(), "data")

      return {
         props: {
            drugs: data
         }
      }
   } catch (error) {
      console.error(error);
      return {
         props: {
            drugs: { drugCategoryId: "error", drugName: error, drugPrice: "error" }
         }
      }

   }



}

function drug_store({ drugs }) {
   // const [drugs, setDrugs] = useState([      ])
   return (
      <>
         <Header />
         <section className="text-gray-600 body-font">
            <div className="container px-5 py-24 mx-auto">
               <div className="flex flex-wrap -m-4">

                  {drugs.map((drug) => (

                     <div key={drug.drugId} className="lg:w-1/4 md:w-1/2 p-4 w-full">
                        <a className="block relative h-48 rounded overflow-hidden">
                           <img alt="ecommerce" className="object-cover object-center w-full h-full block" src="https://dummyimage.com/420x260" />
                        </a>
                        <div className="mt-4">
                           <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">{drug.drugCategoryId}</h3>
                           <h2 className="text-gray-900 title-font text-lg font-medium">{drug.drugName}</h2>
                           <p className="mt-1">$${drug.drugPrice}</p>
                           <Button variant="contained" color="primary"
                              onClick={async () => {
                                 await DrugService.deleteDrug(drug.drugId)
                              }}>
                              delete Drug</Button>
                        </div>
                     </div>
                  ))}
               </div>
            </div>
            <div>

            </div>
         </section>

      </>
   )
}
{/* <div className="lg:w-1/4 md:w-1/2 p-4 w-full">
                        {drug.drugId}
                     </div> */}
export default drug_store