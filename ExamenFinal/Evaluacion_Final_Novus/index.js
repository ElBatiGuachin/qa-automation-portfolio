const report = require('multiple-cucumber-html-reporter');
report.generate({
   jsonDir: 'target/cucumber-report/',
    reportPath: 'target/cucumber-html-report/',
    metadata:{
        browser: {
            name: 'chrome',
            version: 'latest'
        },
        device: 'MacBook Pro',
        platform: {
            name: 'macOS'
        }
    },
    customData: {
        title: 'Run info',
        data: [
            {label: 'Project', value: 'Proyecto SauceDemo_Final_Novus'},
            {label: 'Generated on', value: new Date().toLocaleString()}
        ]
    }
});
