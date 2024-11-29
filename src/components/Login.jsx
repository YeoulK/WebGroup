import React from 'react';
import './Login.css';

const Login = () => {
  return (
    <div className="login-container">
      <h1 className="login-title">
        Welcome to
        <br />
        <span className="brand-name">Book Store</span>
      </h1>
      <form className="login-form">
        <input
          type="text"
          placeholder="Username or e-mail"
          className="login-input"
        />
        <input
          type="password"
          placeholder="Password"
          className="login-input"
        />
        <div className="login-options">
          <label>
            <input type="checkbox" /> Remember Me
          </label>
          <a href="#" className="forgot-password">
            Forgot Password?
          </a>
        </div>
        <button type="submit" className="login-button">
          Log in
        </button>
      </form>
      <p className="signup-text">
        Don't have an account?{' '}
        <a href="#" className="signup-link">
          Sign Up
        </a>
      </p>
    </div>
  );
};

export default Login;
