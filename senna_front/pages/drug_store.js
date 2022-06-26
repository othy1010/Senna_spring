import React from 'react'
import Header from '../components/Header'
import { useState } from 'react'

export async function getStaticProps() {
   try {
      const response = await fetch("http://localhost:8080/api/drugs").catch(err => console.log(err))
      const data = await response.json()
      console.log(data, "data")
      return {
         props: {
            drugs: data
         }
      }
   } catch (error) {
      console.error(error);
      return {
         props: {
            drugs: "error"
         }
      }
      // expected output: ReferenceError: nonExistentFunction is not defined
      // Note - error messages will vary depending on browser
   }



}

function drug_store({ drugs }) {
   // const [drugs, setDrugs] = useState([      ])
   return (
      <>
         <Header />
         {drugs ? <section className="text-gray-600 body-font">
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
                           <p className="mt-1">${drug.drugPrice}</p>
                        </div>
                     </div>
                  ))}
               </div>
            </div>
         </section> : <div>Loading...</div>}

      </>
   )
}
{/* <div className="lg:w-1/4 md:w-1/2 p-4 w-full">
                        {drug.drugId}
                     </div> */}
export default drug_store