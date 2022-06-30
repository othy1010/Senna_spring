import React from 'react'
import { useRouter } from 'next/router'
import Header from '../../components/Header'
import DrugService from '../api/DrugService'
import { GetStaticPaths } from 'next'
import drugImage from '../../assets/drug.svg'
import Image from 'next/image'
import DrugCreation from '../../components/DrugCreation'



export async function getStaticPaths() {
   return {
      paths: [], //indicates that no page needs be created at build time
      fallback: 'blocking' //indicates the type of fallback
   }
}
export async function getStaticProps(context) {
   const drugId_ = context.params.drugId
   console.log(drugId_, "🚧")

   try {
      const response = await DrugService.getDrugById(drugId_)
      const data = await response.data;
      console.log(data, "⚡data⚡")

      return {
         props: {
            drug: data
         }
      }

   } catch (err) {
      console.log(err)
      // throw (err)
   }




}
function Drug({ drug }) {

   const router = useRouter()

   const deleteDrug = async () => {
      try {
         await DrugService.deleteDrug(drug.drugId)
         router.push('/drugstore')

      } catch (err) {
         console.log(err)
      }
   }

   const updateDrug = async () => {
      try {
         await DrugService.updateDrug(drug.drugId, drug)
         router.push(`/drugstore/${drug.drugId}`)

      } catch (err) {
         console.log(err)
      }
   }
   const createDrug = async () => {
      const d = {
         drugName: 'DOLIPRANE 100 mg pdre p sol buv en sachet-dose',
         drugDescription: 'Le paracétamol, aussi appelé acétaminophène, est un composé chimique utilisé comme antalgique et antipyrétique, qui figure parmi les médicaments les plus communs, utilisés et prescrits au monde.\n Poudre pour solution buvable à 100, 150, 200 et 300 mg :  Sachets-dose, boîtes de 12.',
         drugPrice: 50,
         drugQuantity: 80,
         drugCreatedAt: '2022-06-28T18:03:12.06292',
         drugStock: 100,
         needPrescription: false,
         drugCategoryId: 2,
         drugSupplierId: 2,
         drugUsage: 'no usage',
         drugWarnings: 'Ne pas prendre pour les femmes enceintes',
         drugSideEffects: 'no side effects'
      }
      const d1 = {
         drugName: "AUREOMYCINE EVANS 3 % pom",
         drugDescription: "MEDICAMENTS DERMATOLOGIQUES En raison du risque de photosensibilisation, éviter lexposition aux rayonnements UV solaires ou artificiels.Risque de sélection de germes résistants en cas de traitement prolongé.Cette forme pommade nest pas adaptée au traitement des lésions suintantes, macérées, des plis ni des ulcères de jambe.Ce médicament contient de la lanoline (graisse de laine) et peut provoquer des réactions cutanées locales (par exemple : dermatite de contact).",
         drugPrice: 20,
         drugQuantity: 1,
         drugCreatedAt: "2022-06-28T18:03:12.06292",
         drugStock: 100,
         needPrescription: false,
         drugCategoryId: 2,
         drugSupplierId: 2,
         drugUsage: "Everything",
         drugWarnings: "En raison du risque de photosensibilisation, éviter lexposition aux rayonnements UV solaires ou artificiels.",
         drugSideEffects: "no side effects"
      }
      try {
         await DrugService.createDrug(d1)
         await DrugService.createDrug(d)

         router.push('/drugstore')

      } catch (err) {
         console.log(err)
      }
   }


   return (
      <>
         <Header />
         <section className="text-gray-600 body-font overflow-hidden ">
            <div className="container px-5 py-24 mx-auto">
               <div className="lg:w-4/5 mx-auto flex flex-wrap">
                  <div className=" pr-10">
                     <Image
                        alt="drugImage"
                        src={drugImage}
                        layout="intrinsic"
                        width={550}
                        height={550}
                     /></div>
                  <div className="lg:w-1/2 w-full lg:pl-10 lg:py-6 mt-6 lg:mt-0">
                     <h2 className="text-sm title-font text-gray-500 tracking-widest"></h2>
                     <h1 className="text-gray-900 text-3xl title-font font-medium mb-1">{drug.drugName}</h1>
                     <div className="flex flex-col gap-2 mb-4">
                        categorie

                        <p className="leading-relaxed">
                           {drug.drugDescription}.
                        </p>
                        <p className="leading-relaxed text-xl font-semibold">Usage:</p>
                        <p className="leading-relaxed">{drug.drugUsage}.</p>
                        <p className="leading-relaxed text-xl font-semibold">Warnings</p>
                        <p className="leading-relaxed">{drug.drugWarnings}.</p>
                        <p className="leading-relaxed text-xl font-semibold">Side Effects</p>
                        <p className="leading-relaxed">{drug.drugSideEffects}.</p>
                     </div>
                     <div className="flex mt-6 items-center pb-5 border-b-2 border-gray-100 mb-5">

                     </div>
                     <div className="flex">
                        <span className="title-font font-medium text-2xl text-gray-900">
                           {drug.drugPrice} DH
                        </span>
                        <button type="button" className="flex ml-auto text-white bg-indigo-500 border-0 py-2 px-6 focus:outline-none hover:bg-indigo-600 rounded" onClick={deleteDrug}>Order</button>
                        <DrugCreation detail={drug} />

                        <button className="rounded-full w-10 h-10 bg-gray-200 p-0 border-0 inline-flex items-center justify-center text-gray-500 ml-4" onClick={createDrug}>
                           <svg fill="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-5 h-5" viewBox="0 0 24 24">
                              <path d="M20.84 4.61a5.5 5.5 0 00-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 00-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 000-7.78z"></path>
                           </svg>
                        </button>
                     </div>
                  </div>
               </div>
            </div>
         </section></>
   )
}

export default Drug