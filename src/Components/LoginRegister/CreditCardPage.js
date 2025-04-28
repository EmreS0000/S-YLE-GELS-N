import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; 
import './CreditCardPage.css';

const CreditCardPage = () => {
  const navigate = useNavigate(); 

  const [cardNumber, setCardNumber] = useState('');
  const [expiryMonth, setExpiryMonth] = useState('');
  const [expiryYear, setExpiryYear] = useState('');
  const [cvv, setCvv] = useState('');
  const [nameOnCard, setNameOnCard] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    navigate('/success'); 
  };

  return (
    <div className="credit-card-page">
      <h2>Kredi Kartı Bilgileri</h2>

      <form onSubmit={handleSubmit}>
        <div className="input-group">
          <label>Kart Numarası</label>
          <input
            type="text"
            placeholder="Kart Numarası"
            value={cardNumber}
            onChange={(e) => setCardNumber(e.target.value)}
            maxLength="16"
            required
          />
        </div>

        <div className="input-group">
          <label>Son Kullanma Tarihi</label>
          <div style={{ display: 'flex', gap: '10px' }}>
            <select value={expiryMonth} onChange={(e) => setExpiryMonth(e.target.value)} required>
              <option value="">Ay</option>
              {[...Array(12)].map((_, i) => (
                <option key={i} value={i + 1}>
                  {String(i + 1).padStart(2, '0')}
                </option>
              ))}
            </select>
            <select value={expiryYear} onChange={(e) => setExpiryYear(e.target.value)} required>
              <option value="">Yıl</option>
              {Array.from({ length: 16 }, (_, i) => 2025 + i).map((year) => (
                <option key={year} value={year}>
                  {year}
                </option>
              ))}
            </select>
          </div>
        </div>

        <div className="input-group">
          <label>CVV</label>
          <input
            type="text"
            placeholder="CVV"
            value={cvv}
            onChange={(e) => setCvv(e.target.value)}
            maxLength="3"
            required
          />
        </div>

        <div className="input-group">
          <label>Kart Üzerindeki İsim</label>
          <input
            type="text"
            placeholder="Ad Soyad"
            value={nameOnCard}
            onChange={(e) => setNameOnCard(e.target.value)}
            required
          />
        </div>

        <button type="submit" className="submit-btn">Ödeme Yap</button>
      </form>
    </div>
  );
};

export default CreditCardPage;
