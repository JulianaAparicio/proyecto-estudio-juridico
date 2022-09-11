import { Link, Outlet, useSearchParams } from "react-router-dom";
import { getAllUsers } from "../users";

const Users = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const users = getAllUsers();
    const filter = searchParams.get("filter") ?? "";

    const handlerFilter = (e) => {
        setSearchParams({filter: e.target.value})
    }

    return(
        <div>
            <h1>Users</h1>
            <input onChange={handlerFilter} type="text" placeholder="filter"/>
            <ul>
                {users.filter((user) => {
                    if(!filter) return true;
                    const name = user.name.toLowerCase();
                    return name.includes(filter.toLowerCase())
                }).map((user) => (
                <li key={user.id}> 
                    <h2>
                        <Link to={user.id.toString()}>{user.name}</Link>
                    </h2> 
                </li>
                ))}
            </ul>
            <article>
                <Outlet/>
            </article>
        </div>
        )
}

export default Users;