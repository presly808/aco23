import $ from "jquery";

import React from 'react';
import ReactDOM from 'react-dom';

import Header from './react_components/Header.js';
import Footer from "./react_components/Footer";

import Login from './react_components/Login.js';
import Join from './react_components/Join.js';
import Table from "./react_components/Table"

class App extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            headerText: 'Log In',
            showLogin: true,
            showJoin: false,
            showTable: false,
            key: null,
            role: null
        };

        this.loginFunction = this.loginFunction.bind(this);
        this.toJoinFunction = this.toJoinFunction.bind(this);
        this.joinFunction = this.joinFunction.bind(this);
        this.refreshFunction = this.refreshFunction.bind(this);

    }

    loginFunction(key, role) {
        alert('Logged in(key=' + key + ', role=' + role +')');
        this.setState({
            headerText: 'Table',
            showLogin: false,
            showTable: true,
            key: key,
            role: role
        });
    }

    toJoinFunction() {
        this.setState({
            headerText: 'Sign up',
            showLogin: false,
            showJoin: true,
        });
    }

    joinFunction() {
        alert('Congratulation with joining up');
        this.setState({
            headerText: 'Log In',
            showLogin: true,
            showJoin: false,
        });
    }

    refreshFunction() {
        alert("Refreshed");
        alert(`Role ${this.state.role}, key ${this.state.key}`);
    }

    render() {
        return (
            <div>
                <Header text={this.state.headerText}/>
                {this.state.showLogin &&
                <Login loginFunction={this.loginFunction} toJoinFunction={this.toJoinFunction}/>}
                {this.state.showJoin && <Join joinFunction={this.joinFunction}/>}
                {this.state.showTable && <Table refreshFunction={this.refreshFunction}/>}
                <Footer/>
            </div>
        );
    }
}

$(document).ready(() => {
    ReactDOM.render(
        <App/>,
        document.getElementById('root')
    );
});
