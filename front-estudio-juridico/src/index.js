import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Home from './routes/Home';
import Users from './routes/Users';
import Navbar from './routes/Navbar';
import User from './routes/User';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
  <Routes>
      <Route index element={<Home/>}/>
      <Route path='/navbar' element={<Navbar/>}/>
      <Route path='/users' element={<Users/>}>
        <Route index element={<div>Select user</div>}/>
        <Route path=':userId' element={<User/>}/>
      </Route>
      <Route path='*' element={<Navigate replace to="/" />}/>
  </Routes>
  </BrowserRouter>
  );