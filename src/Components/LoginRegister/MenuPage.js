import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './MenuPage.css';
import { FaMapMarkerAlt, FaSearch, FaShoppingCart, FaUserCircle } from 'react-icons/fa';


import donerImage from '../Assets/11262643241010.jpg';
import hamurberImage from '../Assets/220602_DD_Best-Ever-Cheeseburger_267-500x500.jpg';
import kebapImage from '../Assets/download.jpg';
import pideImage from '../Assets/download-1.jpg';
import pizzaImage from '../Assets/63dfcf_22f0e707a5444c0f911ea4ddaa58c8e2~mv2.avif';
import tantuniImage from '../Assets/f01x-listing.jpg';
import tatliImage from '../Assets/download-2.jpg';
import dunyamutfagıImage from '../Assets/download-3.jpg';
import tostImage from '../Assets/download-4.jpg';
import lahmacunImage from '../Assets/download-5.jpg';
import kofteImage from '../Assets/7e5a0-shutterstock_1825229714_672644760707.webp';
import macdo from '../Assets/WEB3_1283.jpg';
import burgerking from '../Assets/download-6.jpg';

const categories = [
  { name: 'Döner', image: donerImage },
  { name: 'Hamburger', image: hamurberImage },
  { name: 'Kebap', image: kebapImage },
  { name: 'Pide', image: pideImage },
  { name: 'Pizza', image: pizzaImage },
  { name: 'Tantuni', image: tantuniImage },
  { name: 'Tatlılar', image: tatliImage },
  { name: 'Dünya Mutfağı', image: dunyamutfagıImage },
  { name: 'Tost & Sandviç', image: tostImage },
  { name: 'Lahmacun', image: lahmacunImage },
  { name: 'Çiğ Köfte', image: kofteImage },
];

const restaurantData = {
  'Hamburger': [
    { name: "McDonald's", image: macdo, price: 255 },
    { name: "Burger King", image: burgerking, price: 225 },
  ],
  'Döner': [
    { name: "Dönerci Ali Usta", image: 'https://upload.wikimedia.org/wikipedia/commons/6/65/Kebab.jpg', price: 80 },
    { name: "Usta Dönerci", image: 'https://upload.wikimedia.org/wikipedia/commons/4/4e/Doner_kebab.jpg', price: 90 },
  ],
};

const MenuPage = () => {
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [cartItems, setCartItems] = useState([]);
  const [cartOpen, setCartOpen] = useState(false);
  const navigate = useNavigate();

  const handleCategoryClick = (category) => {
    setSelectedCategory(category);
  };

  const toggleCart = () => {
    setCartOpen(!cartOpen);
  };

  const handleAddToCart = (item) => {
    setCartItems((prevCart) => [...prevCart, item]);
  };

  const handleRemoveFromCart = (index) => {
    setCartItems((prevCart) => prevCart.filter((_, i) => i !== index));
  };

  const goToPaymentPage = () => {
    navigate('/payment', { state: { cartItems } });
  };

  return (
    <div>
 
      <div className="panel">
        <div className="location-container">
          <div className="location">
            <FaMapMarkerAlt size={20} style={{ marginRight: '5px' }} />
            <span>Malatya, Battalgazi</span>
          </div>
        </div>

  
        <div className="search-container">
          <input type="text" placeholder="Yemek ara..." />
          <FaSearch size={20} style={{ marginLeft: '10px' }} />
        </div>

    
        <div className="profile-container">
          <div className="cart-container" onClick={toggleCart} style={{ cursor: 'pointer' }}>
            <FaShoppingCart size={30} />
            <span>{cartItems.length}</span>
          </div>
          <div className="profile-container">
            <FaUserCircle size={30} />
            <span>Zeynep</span>
          </div>
        </div>
      </div>

      
      {cartOpen && (
        <div className="cart-modal">
          <h2>Sepetim</h2>
          {cartItems.length === 0 ? (
            <p>Sepetiniz boş.</p>
          ) : (
            <ul>
              {cartItems.map((item, index) => (
                <li key={index}>
                  {item.name} - ₺{item.price}
                  <button onClick={() => handleRemoveFromCart(index)}>Kaldır</button>
                </li>
              ))}
            </ul>
          )}
          <button onClick={toggleCart}>Kapat</button>
        </div>
      )}

      
      <div className="categories-container">
        {selectedCategory ? (
          <div className="selected-category">
            <h2>{selectedCategory.name} Restoranları</h2>

            <div className="restaurant-list">
              {restaurantData[selectedCategory.name] ? (
                restaurantData[selectedCategory.name].map((restaurant, index) => (
                  <div className="restaurant-card" key={index}>
                    <img src={restaurant.image} alt={restaurant.name} />
                    <h3>{restaurant.name}</h3>
                    <p>₺{restaurant.price}</p>
                    <button className="add-to-cart-button" onClick={() => handleAddToCart(restaurant)}>
                      🛒 Sepete Ekle
                    </button>
                  </div>
                ))
              ) : (
                <p>Bu kategoride restoran bulunamadı.</p>
              )}
            </div>

            <button className="back-button" onClick={() => setSelectedCategory(null)}>
              ← Geri Dön
            </button>
          </div>
        ) : (
          categories.map((category, index) => (
            <div className="category" key={index} onClick={() => handleCategoryClick(category)}>
              <img src={category.image} alt={category.name} />
              <span>{category.name}</span>
            </div>
          ))
        )}
      </div>

      
      <div style={{ textAlign: 'center', marginTop: '20px' }}>
        <button 
          onClick={goToPaymentPage}
          style={{
            padding: '10px 20px',
            backgroundColor: '#fd942a',
            color: 'white',
            border: 'none',
            borderRadius: '5px',
            fontSize: '18px',
            cursor: 'pointer',
          }}
        >
          Ödemeye Git
        </button>
      </div>
    </div>
  );
};

export default MenuPage;
