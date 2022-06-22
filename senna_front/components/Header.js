/* This example requires Tailwind CSS v2.0+ */
import { Fragment } from 'react'
import sennaLogo from '../assets/logo.svg'
import { Avatar } from '@mui/material'
import Image from 'next/image'
import { Popover, Transition } from '@headlessui/react'
import {
   BookmarkAltIcon,
   CalendarIcon,
   ChartBarIcon,
   CursorClickIcon,
   MenuIcon,
   PhoneIcon,
   PlayIcon,
   RefreshIcon,
   ShieldCheckIcon,
   SupportIcon,
   ViewGridIcon,
   XIcon,
} from '@heroicons/react/outline'
import { ChevronDownIcon } from '@heroicons/react/solid'
import { getAuth } from "firebase/auth";
import app from './firebase.config'
const drugs = [
   {
      name: 'Analytics',
      description: 'Get a better understanding of where your traffic is coming from.',
      href: '#',
      icon: ChartBarIcon,
   },
   {
      name: 'Engagement',
      description: 'Speak directly to your customers in a more meaningful way.',
      href: '#',
      icon: CursorClickIcon,
   },
   { name: 'Security', description: "Your customers' data will be safe and secure.", href: '#', icon: ShieldCheckIcon },
   {
      name: 'Integrations',
      description: "Connect with third-party tools that you're already using.",
      href: '#',
      icon: ViewGridIcon,
   },
   {
      name: 'Automations',
      description: 'Build strategic funnels that will drive your customers to convert',
      href: '#',
      icon: RefreshIcon,
   },
]
const drugs_plus = [
   { name: 'Watch Demo', href: '#', icon: PlayIcon },
   { name: 'Contact Sales', href: '#', icon: PhoneIcon },
]
const more1 = [
   {
      name: 'Help Center',
      description: 'Get all of your questions answered in our forums or contact support.',
      href: '#',
      icon: SupportIcon,
   },

   {
      name: 'Events',
      description: 'See what meet-ups and other events we might be planning near you.',
      href: '#',
      icon: CalendarIcon,
   },
   { name: 'Security', description: 'Understand how we take your privacy seriously.', href: '#', icon: ShieldCheckIcon },
]
const more2 = [
   { id: 1, name: 'Boost your conversion rate', href: '#' },
   { id: 2, name: 'How to use search engine optimization to drive traffic to your site', href: '#' },
   { id: 3, name: 'Improve your customer experience', href: '#' },
]




function classNames(...classes) {
   return classes.filter(Boolean).join(' ')
}

export default function Header() {

   const auth = getAuth(app);
   const user = auth.currentUser;

   return (
      <Popover className="relative bg-white">
         <div className="max-w-7xl mx-auto px-4 sm:px-6">
            <div className="flex justify-between items-center border-b-2 border-gray-100 py-6 md:justify-start md:space-x-10">
               <div className="flex justify-start lg:w-0 lg:flex-1">
                  <a href="/">
                     <Image src={sennaLogo} height={60} width={90} />

                  </a>

               </div>
               <div className="-mr-2 -my-2 md:hidden">
                  <Popover.Button className="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500">
                     <span className="sr-only">Open menu</span>
                     <MenuIcon className="h-6 w-6" aria-hidden="true" />
                  </Popover.Button>
               </div>
               <Popover.Group as="nav" className="hidden md:flex space-x-10">
                  <a href="#" className="text-base font-medium text-gray-500 hover:text-gray-900">
                     Drug-store
                  </a>

                  <a href="#" className="text-base font-medium text-gray-500 hover:text-gray-900">
                     Find a Doctor
                  </a>
                  <a href="#" className="text-base font-medium text-gray-500 hover:text-gray-900">
                     About us
                  </a>


               </Popover.Group>
               {user ? (
                  <div className="hidden md:flex items-center justify-end md:flex-1 lg:w-0">
                     <div className="">

                        <Popover.Button
                           className={classNames(
                              open ? 'text-gray-900' : 'text-gray-500',
                              'group bg-white rounded-md inline-flex items-center text-base font-medium hover:text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500'
                           )}
                        >
                           <Avatar
                              className="w-8 h-8 rounded-full"
                              src={user.photoURL}
                              alt={user.displayName}
                           />
                        </Popover.Button>
                     </div>
                  </div>
               )
                  : (<div className="hidden md:flex items-center justify-end md:flex-1 lg:w-0">
                     <a href="/sign_in" className="whitespace-nowrap text-base font-medium text-gray-500 hover:text-gray-900">
                        Sign in
                     </a>
                     <a
                        href="/register"
                        className="ml-8 whitespace-nowrap inline-flex items-center justify-center px-4 py-2 border border-transparent rounded-md shadow-sm text-base font-medium text-white bg-indigo-600 hover:bg-indigo-700"
                     >
                        Sign up
                     </a>
                  </div>)
               }
            </div>
         </div>

         <Transition
            as={Fragment}
            enter="duration-200 ease-out"
            enterFrom="opacity-0 scale-95"
            enterTo="opacity-100 scale-100"
            leave="duration-100 ease-in"
            leaveFrom="opacity-100 scale-100"
            leaveTo="opacity-0 scale-95"
         >
            <Popover.Panel focus className="absolute top-0 inset-x-0 p-2 transition transform origin-top-right md:hidden">
               <div className="rounded-lg shadow-lg ring-1 ring-black ring-opacity-5 bg-white divide-y-2 divide-gray-50">
                  <div className="pt-5 pb-6 px-5">
                     <div className="flex items-center justify-between">
                        <div>
                           <img
                              className="h-8 w-auto"
                              src="https://tailwindui.com/img/logos/workflow-mark-indigo-600.svg"
                              alt="Workflow"
                           />
                        </div>
                        <div className="-mr-2">
                           <Popover.Button className="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500">
                              <span className="sr-only">Close menu</span>
                              <XIcon className="h-6 w-6" aria-hidden="true" />
                           </Popover.Button>
                        </div>
                     </div>

                  </div>
                  <div className="py-6 px-5 space-y-6">
                     <div className="grid grid-cols-2 gap-y-4 gap-x-8">
                        <a href="#" className="text-base font-medium text-gray-900 hover:text-gray-700">
                           Pricing
                        </a>

                        <a href="#" className="text-base font-medium text-gray-900 hover:text-gray-700">
                           Docs
                        </a>
                        {more1.map((item) => (
                           <a
                              key={item.name}
                              href={item.href}
                              className="text-base font-medium text-gray-900 hover:text-gray-700"
                           >
                              {item.name}
                           </a>
                        ))}
                     </div>
                     <div>
                        <a
                           href="#"
                           className="w-full flex items-center justify-center px-4 py-2 border border-transparent rounded-md shadow-sm text-base font-medium text-white bg-indigo-600 hover:bg-indigo-700"
                        >
                           Sign up
                        </a>
                        <p className="mt-6 text-center text-base font-medium text-gray-500">
                           Existing customer?{' '}
                           <a href="#" className="text-indigo-600 hover:text-indigo-500">
                              Sign in
                           </a>
                        </p>
                     </div>
                  </div>
               </div>
            </Popover.Panel>
         </Transition>
      </Popover>
   )
}

// import {
//    BarChart,
//    SearchRounded,
//    ShoppingCartRounded,
// } from "@mui/icons-material";
// import React, { useEffect } from "react";
// // import { useStateValue } from "./StateProvider";

// function Header() {
//    // const [{ cart }, dispatch] = useStateValue();

//    useEffect(() => {
//       const toggleIcon = document.querySelector(".toggleMenu");
//       toggleIcon.addEventListener("click", () => {
//          document.querySelector(".rightMenu").classList.toggle("active");
//       });
//    }, []);

//    return (
//       <header>
//          <img
//             src=""//firebase
//             alt=""
//             className="logo"
//          />

//          <div className="inputBox">
//             <SearchRounded className="searchIcon" />
//             <input type="text" placeholder="Search" />
//          </div>

//          <div className="shoppingCart">
//             <ShoppingCartRounded className="cart" />
//             {/* <div className={`${!cart ? "noCartItem" : "cart_content"}`}>
//                <p>{cart ? cart.length : ""}</p> */}
//             {/* </div> */}
//          </div>

//          <div className="profileContainer">
//             <div className="imgBox">
//                <img
//                   src=""//firebase

//                   alt=""
//                />
//             </div>
//             <h2 className="userName">Vetrivel Ravi</h2>
//          </div>

//          <div className="toggleMenu">
//             <BarChart className="toggleIcon" />
//          </div>
//       </header>
//    );
// }

// export default Header;
