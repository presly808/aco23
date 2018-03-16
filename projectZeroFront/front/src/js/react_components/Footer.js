import React from 'react';

class Footer extends React.Component {
    render() {
        return (
            <div className="container-fluid footer text-right">
                <a target="_blank" href="https://github.com/les0327">
                    <p className="text-muted">
                        About me
                    </p>
                </a>
            </div>
        );
    };
}

export default Footer;