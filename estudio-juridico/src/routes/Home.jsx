import { FaPhoneAlt, FaMapMarkerAlt } from "react-icons/fa";
import { SiGmail } from "react-icons/si";
import styles from "../styles/home.module.css";

const Home = () => {
    return(
        <div className={styles.home__container}>
            <div>
                <a className="link" href="/">
                    <img className="logo-image" src="../../images/logoPequenioTransparente.png" alt="Estudio Jurídico Barreiro & Asociados" />
                </a>
                <h1>Estudio Jurídico Barreiro & Asociados</h1>
            </div>
            <div className={styles.info__container}>
                <div>
                    <FaMapMarkerAlt/>
                    <strong>Calle 12 N° 779 3° C - La Plata</strong>
                </div>
                <div>
                    <FaPhoneAlt/>
                    <strong>0221 - 1111111</strong>
                </div>
                <div>
                    <SiGmail/>
                    <strong>estudiobarreirolp@gmail.com</strong>
                </div>
            </div>
        </div>
    )
}

export default Home;