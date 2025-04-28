import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';


import LoginRegister from './Components/LoginRegister/LoginRegister';
import MenuPage from './Components/LoginRegister/MenuPage';
import CheckoutPage from './Components/LoginRegister/CheckoutPage';
import CreditCardPage from './Components/LoginRegister/CreditCardPage';
import PaymentSuccessPage from './Components/LoginRegister/PaymentSuccessPage'; 

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false); 
  const [userInfo, setUserInfo] = useState({}); 

  return (
    <Router>
      <Routes>

        
        <Route 
          path="/" 
          element={
            isLoggedIn 
              ? <Navigate to="/menu" /> 
              : <LoginRegister setIsLoggedIn={setIsLoggedIn} setUserInfo={setUserInfo} />
          } 
        />

     
        <Route 
          path="/menu" 
          element={
            isLoggedIn 
              ? <MenuPage userInfo={userInfo} /> 
              : <Navigate to="/" />
          } 
        />

        
        <Route 
          path="/payment" 
          element={
            isLoggedIn 
              ? <CheckoutPage /> 
              : <Navigate to="/" />
          } 
        />

       
        <Route 
          path="/credit-card" 
          element={
            isLoggedIn 
              ? <CreditCardPage /> 
              : <Navigate to="/" />
          } 
        />

        
        <Route 
          path="/success" 
          element={
            isLoggedIn 
              ? <PaymentSuccessPage userInfo={userInfo} /> 
              : <Navigate to="/" />
          } 
        />

        
        <Route 
          path="*" 
          element={<Navigate to="/" />} 
        />

      </Routes>
    </Router>
  );
}

export default App;
