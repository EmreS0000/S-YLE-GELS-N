import React from 'react';
import { useNavigate } from 'react-router-dom';

const PaymentSuccessPage = ({ userInfo }) => {
  const navigate = useNavigate();

  const handleBackToMenu = () => {
    navigate('/menu');
  };

  const orderNumber = Math.floor(Math.random() * 90000) + 10000; 

  return (
    <div style={{
      textAlign: 'center',
      marginTop: '100px',
      backgroundColor: '#f9f9f9',
      padding: '40px',
      borderRadius: '10px',
      maxWidth: '500px',
      marginLeft: 'auto',
      marginRight: 'auto',
      boxShadow: '0 4px 10px rgba(0,0,0,0.1)'
    }}>
      <h1 style={{ color: '#28a745', fontSize: '36px' }}>
        🥳 Ödeme Başarılı! 🎉
      </h1>

      <p style={{ fontSize: '20px', marginTop: '20px' }}>
        Teşekkürler <strong>{userInfo?.name || 'Müşteri'}</strong>!
      </p>

      <p style={{ fontSize: '18px', marginTop: '10px' }}>
        Sipariş Numaranız: <strong>#{orderNumber}</strong>
      </p>

      <p style={{ fontSize: '16px', marginTop: '10px', color: 'gray' }}>
        Sipariş bilgileriniz {userInfo?.email || 'e-posta adresinize'} gönderilecektir.
      </p>

      <button
        onClick={handleBackToMenu}
        style={{
          marginTop: '30px',
          padding: '12px 24px',
          fontSize: '18px',
          backgroundColor: '#fd942a',
          color: 'white',
          border: 'none',
          borderRadius: '8px',
          cursor: 'pointer'
        }}
      >
        Ana Menüye Dön
      </button>
    </div>
  );
};

export default PaymentSuccessPage;
