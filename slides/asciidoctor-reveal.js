// Load asciidoctor.js + asciidoctor-template.js
var asciidoctor = require('asciidoctor.js')();
var Asciidoctor = asciidoctor.Asciidoctor();
var Opal = asciidoctor.Opal;
Opal.load('nodejs');
Opal.load('pathname');
require('asciidoctor-template.js');

// Convert the document 'presentation.adoc' using Reveal.js backend
var attributes = 'revealjsdir=node_modules/reveal.js@';
var options = Opal.hash({safe: 'safe',
    backend: 'revealjs',
    attributes: attributes});
Asciidoctor.$convert_file('presentation.adoc', options);