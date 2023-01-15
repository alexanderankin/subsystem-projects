$(() => {
  let scenarioGraphicElement = document.querySelector('svg#scenario-graphic');
  adjustSvgSize();
  addEventListener('resize', adjustSvgSize)

  let scenarioGraphic = d3.select('svg#scenario-graphic');

  setupConcentricCircles(scenarioGraphicElement, scenarioGraphic);
});

function adjustSvgSize() {
  const scenarioGraphicElement = document.querySelector('svg#scenario-graphic');
  let parent = scenarioGraphicElement.parentElement;
  let { clientHeight: pHeight, clientWidth: pWidth } = parent;
  pWidth -= parseInt('0' + $(parent).css('padding-left').replace(/\D+/g, ''), 10)
  pWidth -= parseInt('0' + $(parent).css('padding-right').replace(/\D+/g, ''), 10)
  pHeight -= parseInt('0' + $(parent).css('padding-top').replace(/\D+/g, ''), 10)
  pHeight -= parseInt('0' + $(parent).css('padding-bottom').replace(/\D+/g, ''), 10)
  scenarioGraphicElement.style.height = pHeight - 80 + 'px';
  scenarioGraphicElement.style.width = pWidth + 'px';
}

function setupConcentricCircles(scenarioGraphicElement, scenarioGraphic) {
  let {
    clientHeight: height,
    clientWidth: width,
  } = scenarioGraphicElement;


  for (let radius of [-1, 0, 1].map(e => 100 + (30 * e))) {
    // http://www.d3noob.org/2014/02/styles-in-d3js.html
    scenarioGraphic.append('circle')
      .attr('cx', ~~(width / 2))
      .attr('cy', ~~(height / 2))
      .attr('r', radius)
      .style('fill', '#0000')
      .style('stroke', '#000')
      .style('stroke-width', 1)
    ;
  }
}
