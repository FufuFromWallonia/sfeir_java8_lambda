module.exports = function(grunt) {

    grunt.loadNpmTasks('grunt-watch-change');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-execute');

    var taskConfig = {

        execute: {
            target: {
                // execute javascript files in a node child_process
                src: ['asciidoctor-reveal.js']
            }
        },

        adoc:{

        },

        // This will watch changes on all files inside `src` directory.
        watch: {
            source: {
                files: ['presentation.adoc'],
                tasks: ['execute:target']
            }
        }
    };

    grunt.initConfig(taskConfig);

    // We must run `watchchange` task before `watch` task.
    grunt.registerTask('watching', ['watch']);
    grunt.registerTask('execute_simple_target', 'fuck', function(){

        grunt.task.run(['execute:target']);

    });
};