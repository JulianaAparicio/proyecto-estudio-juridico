import React from 'react'
import { Link } from 'react-router-dom';

const Navbar = () => {
    return(
        <div className="navbar__container">
            <nav>
                <Link to="/">Home</Link> | {" "}
                <Link to="/users">Users</Link> | {" "}
                <Link to="/navbar">Estudio Jurídico Barreiro & Asociados</Link> | {" "}
            </nav>
        </div>
    )
}

export default Navbar;