import React, { useState } from 'react';
import './LoginRegister.css';  

import { FaUserCircle, FaLock, FaEnvelope } from "react-icons/fa";

const LoginRegister = ({ setIsLoggedIn }) => {
  const [action, setAction] = useState('login');  

  
  const handleLogin = () => {
    setIsLoggedIn(true);  
  };

  return (
    <div className={`wrapper ${action !== 'login' ? 'active' : ''}`}>
      
   
      <div className={`form-box login ${action === 'login' ? 'visible' : 'hidden'}`}>
        <form action="">
          <h2>SöyleGelsin</h2>
          <div className="input-box">
            <FaUserCircle className='icon' />
            <input type="text" placeholder='Kullanıcı İsmi' required />
          </div>
          <div className="input-box">
            <FaLock className='icon' />
            <input type="password" placeholder='Şifre' required />
          </div>
          <div className="remember-forgot">
            <label><input type="checkbox" />Beni Hatırla</label>
            <a href="#" onClick={() => setAction('forgot')}>Parolamı Unuttum</a>
          </div>
          <button type="button" onClick={handleLogin}>Giriş Yap</button>
          <div className="register-link">
            <p>Hala kayıt olmadın mı? <a href="#" onClick={() => setAction('register')}>Kayıt Ol</a></p>
          </div>
        </form>
      </div>

     
      <div className={`form-box register ${action === 'register' ? 'visible' : 'hidden'}`}>
        <form action="">
          <h2>Kayıt Ol</h2>
          <div className="input-box">
            <FaEnvelope className='icon' />
            <input type="text" placeholder='E-posta Adresi' required />
          </div>
          <div className="input-box">
            <FaUserCircle className='icon' />
            <input type="text" placeholder='Kullanıcı İsmi' required />
          </div>
          <div className="input-box">
            <FaLock className='icon' />
            <input type="password" placeholder='Şifre' required />
          </div>
          <div className="remember-forgot">
            <label><input type="checkbox" />Bana özel kampanya, tanıtım ve fırsatlardan haberdar olmak istiyorum</label>
          </div>
          <button type="submit">Kayıt Ol</button>
          <div className="register-link">
            <p>Hesabım Var? <a href="#" onClick={() => setAction('login')}>Giriş Yap</a></p>
          </div>
        </form>
      </div>

 
      <div className={`form-box forgot ${action === 'forgot' ? 'visible' : 'hidden'}`}>
        <form action="">
          <h1>Şifremi Unuttum</h1>
          <div className="input-box">
            <FaEnvelope className='icon' />
            <input type="text" placeholder='E-posta Adresi' required />
          </div>
          <button type="submit">Şifre Sıfırla</button>
          <div className="register-link">
            <p>Giriş yapmak ister misin? <a href="#" onClick={() => setAction('login')}>Giriş Yap</a></p>
            <p>Hesabın yok mu? <a href="#" onClick={() => setAction('register')}>Kayıt Ol</a></p>
          </div>
        </form>
      </div>

    </div>
  );
};

export default LoginRegister;
