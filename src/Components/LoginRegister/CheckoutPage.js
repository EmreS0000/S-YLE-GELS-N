import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { FaCreditCard, FaMoneyBillWave } from 'react-icons/fa';
import './CheckoutPage.css';

const CheckoutPage = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const cartItems = location.state?.cartItems || []; 

  const handleCreditCardPayment = () => {
    if (cartItems.length === 0) {
      alert('Sepetiniz boş! Lütfen ürün ekleyin.');
    } else {
      navigate('/credit-card', { state: { cartItems } }); 
    }
  };

  const handleCashPayment = () => {
    if (cartItems.length === 0) {
      alert('Sepetiniz boş! Lütfen ürün ekleyin.');
    } else {
      alert('Kapıda ödeme seçildi! Siparişiniz başarıyla oluşturuldu.');
      navigate('/success'); 
    }
  };

  const totalAmount = cartItems.reduce((acc, item) => acc + Number(item.price), 0); 

  return (
    <div className="checkout-page">
      <div className="checkout-header">
        <h2>Ödeme Sayfası</h2>
      </div>


      <div className="cart-items">
        <h3>Sepetiniz</h3>
        {cartItems.length === 0 ? (
          <p>Sepetiniz boş.</p>
        ) : (
          cartItems.map((item, index) => (
            <div className="cart-item" key={index}>
              <p>{item.name}</p>
              <p>₺{item.price}</p>
            </div>
          ))
        )}
      </div>

   
      <div className="total-amount">
        <h3>Toplam Tutar</h3>
        <p>₺{totalAmount}</p>
      </div>


      <div className="payment-methods">
        <h3>Ödeme Yöntemi</h3>
        <div className="payment-option" onClick={handleCreditCardPayment}>
          <FaCreditCard size={20} />
          <span>Kredi Kartı</span>
        </div>
        <div className="payment-option" onClick={handleCashPayment}>
          <FaMoneyBillWave size={20} />
          <span>Kapıda Ödeme</span>
        </div>
      </div>
    </div>
  );
};

export default CheckoutPage;
