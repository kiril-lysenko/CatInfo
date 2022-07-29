import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import {Component} from "react";
import ListOfCats from "./components/ListOfCats";

class App extends Component {

    render() {
        return (
            <Router>
                <Routes>
                    <Route path='/' exact={true} element={<ListOfCats/>}/>
                    <Route path='/cats' exact={true} element={<ListOfCats/>}/>
                </Routes>
            </Router>
        )
    }
}

export default App;
