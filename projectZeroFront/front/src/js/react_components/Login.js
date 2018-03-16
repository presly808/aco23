import $ from 'jquery';
import React from 'react';

class Login extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            email: '',
            pass: ''
        };

        this.handleEmail = this.handleEmail.bind(this);
        this.handlePass = this.handlePass.bind(this);
        this.handleLogin = this.handleLogin.bind(this);
    }

    handleEmail(event) {
        this.setState({
            email: event.target.value
        });
    }

    handlePass(event) {
        this.setState({
            pass: event.target.value
        });
    }

    handleLogin() {
        let login;
        login = $.ajax({
            method: "POST",
            url: "/login",
            data: JSON.stringify({email: this.state.email, pass: this.state.pass}),
        })
            .done(function (data) {
                const response = data.response;
                const error = data.error;

                if (error) {
                    alert(error.message);
                } else {
                    alert(response);
                    this.props.loginFunction(login.getResponseHeader('key'), response.role);
                }
            });
    }

    render() {
        return (
            <div className="container formDiv">
                <form>
                    <label className="sr-only">Email</label>
                    <input type="email" className="form-control" placeholder={'Enter email'}
                           onChange={this.handleEmail}/>
                    <label className="sr-only">Password</label>
                    <input type="password" className="form-control" placeholder={'Enter password'}
                           onChange={this.handlePass}/>
                </form>
                <button className="btn btn-lg btn-success btn-block" onClick={this.handleLogin}>Sign In</button>
                <p className="text-center">New to ProjectZero? <a onClick={this.props.toJoinFunction}>Sign up</a></p>
            </div>
        );
    };
}

export default Login;