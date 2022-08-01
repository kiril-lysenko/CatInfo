import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import {Component} from "react";
import ListOfCats from "./components/ListOfCats";
import CatColorsInfo from "./components/CatColorsInfo";
import CatsStatisticInfo from "./components/CatsStatisticInfo";

class App extends Component {

    render() {
        return (
            <Router>
                <Routes>
                    <Route path='/' exact={true} element={<ListOfCats/>}/>
                    <Route path='/cats' exact={true} element={<ListOfCats/>}/>
                    <Route path='/cats-statistic/cat-colors' exact={true} element={<CatColorsInfo/>}/>
                    <Route path='/cats-statistic/tail-and-whiskers-length' exact={true} element={<CatsStatisticInfo/>}/>
                </Routes>
            </Router>
        )
    }
}

export default App;
