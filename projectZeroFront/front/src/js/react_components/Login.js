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
        let header;

        fetch('/login', {
            method: 'POST',
            body: JSON.stringify({email: this.state.email, pass: this.state.pass}),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => {
            header = response.headers.get("key");
            return response;
        }).then(response => response.json()).then(responseJson => {
            const response = responseJson.response;
            const error = responseJson.error;

            if (error) {
                alert(error.directMessage);
            } else {
                this.props.loginFunction(header, response.role);
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