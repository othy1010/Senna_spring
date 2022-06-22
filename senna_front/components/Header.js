import { useState } from 'react'
import sennaLogo from '../assets/logo.svg'
import { Avatar } from '@mui/material'

import Badge from '@mui/material/Badge'

import ShoppingCartIcon from '@mui/icons-material/ShoppingCart'
import Image from 'next/image'
import { Popover } from '@headlessui/react'


import { getAuth } from "firebase/auth"

import app from './firebase.config'
import ButtonGroup from '@mui/material/ButtonGroup';
import Button from '@mui/material/Button';
import AddIcon from '@mui/icons-material/Add';
import RemoveIcon from '@mui/icons-material/Remove';
import { IconButton } from '@mui/material'




function classNames(...classes) {
   return classes.filter(Boolean).join(' ')
}

export default function Header() {
   const [count, setCount] = useState(1);
   const [invisible, setInvisible] = useState(false);

   const handleBadgeVisibility = () => {
      setInvisible(!invisible);
   };
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
                     <div className="flex gap-6 justify-center items-center">

                        <div>

                           <IconButton className=" w-12 h-12 rounded-full">
                              <Badge badgeContent={count} color="primary">
                                 <ShoppingCartIcon className=" w-10 h-10" />
                              </Badge>
                           </IconButton>
                           {/* <ButtonGroup>
                              <Button
                                 aria-label="reduce"
                                 onClick={() => {
                                    setCount(Math.max(count - 1, 0));
                                 }}
                              >
                                 <RemoveIcon fontSize="small" />
                              </Button>
                              <Button
                                 aria-label="increase"
                                 onClick={() => {
                                    setCount(count + 1);
                                 }}
                              >
                                 <AddIcon fontSize="small" />
                              </Button>
                           </ButtonGroup> */}
                        </div>



                        <Avatar
                           className="w-8 h-8 rounded-full"
                           src={user.photoURL}
                           alt={user.displayName}
                        />
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
