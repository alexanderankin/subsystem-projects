let levels = {
  error: 200,
  warn: 300,
  info: 400,
  debug: 500,
  trace: 600,
}
let level = levels['info'];

function noop() {
}

let logger = Object.entries(levels)
  .reduce((l, [n, num]) => { l[n] = level > num ? console.log : noop; return l; }, {});

// let logger = {
//   debug: level >= levels.debug ? console.log : noop,
//   etc ...
// }

const RING_DIFFERENCE = 30;
const RING_BASE = 100;

/**
 * @typedef {
 *  name: string,
 *  color: string,
 *  location: 'center'|'inner'|'middle'|'outer'|false,
 *  orientation: 'left'|'center'|'right'|false
 * } Bucket
 */
$(() => {
  let scenarioGraphicElement = document.querySelector('svg#scenario-graphic');
  adjustSvgSize();
  addEventListener('resize', adjustSvgSize)

  let scenarioGraphic = d3.select('svg#scenario-graphic');

  let center = setupConcentricCircles(scenarioGraphicElement, scenarioGraphic);

  /**
   * @type {Bucket[]}
   */
  let bodies = [
    {
      name: 'observer',
      color: 'green',
      strokeWidth: 3,
      location: 'inner',
      orientation: 'left'
    },
    {
      name: 'observed',
      color: 'red',
      location: 'middle',
      orientation: 'right',
    },
    {
      name: 'center',
      color: 'black',
    },
  ];

  renderBodies(scenarioGraphic, center, bodies);

  window.Bodies = { bodies, render: renderBodies };
});

/**
 * @param {d3.select} scenarioGraphic
 * @param {{x: number, y: number}} center
 * @param {Bucket[]} bodies
 * @return {Array} newly rendered things
 */
function renderBodies(scenarioGraphic, center, bodies) {
  for (let i = 0; i < bodies.length; i++) {
    let body = bodies[i];
    let {
      name,
      color,
      location,
      orientation
    } = body;

    if (!location || !orientation) {
      logger.debug('not appending', name, 'didn\'t have location/orientation', body)
      continue;
    }

    let { x, y } = center;

    if (name !== 'center') {
      let right = orientation === 'right';
      x += RING_BASE * (right ? 1 : -1);

      x += RING_DIFFERENCE * ({
        inner: right ? -1 : 1,
        middle: 0,
        outer: right ? 1 : -1,
      }[location])

      // should make some constants
      let yDiff = 16 + ({
        inner: -6,
        middle: 0,
        outer: 6,
      }[location])
      logger.trace(yDiff, body)
      y += right ? -yDiff : yDiff;

      logger.debug('name', name, 'using plotted case (not center)', { offsets: { x, y } })
    }

    let newCircle = scenarioGraphic.append('circle')
      .attr('cx', x)
      .attr('cy', y)
      .attr('r', 20)
      .style('fill', '#0000')
      .style('stroke', color || '#000')
      .style('stroke-width', body.strokeWidth || 2)

    // replace
    if (body.circle && typeof body.circle.remove === 'function') body.circle.remove();
    body.circle = newCircle;
  }
}

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

/**
 * @param {Element} scenarioGraphicElement
 * @param {*} scenarioGraphic
 * @return {{x:Number, y:Number}}
 */
function setupConcentricCircles(scenarioGraphicElement, scenarioGraphic) {
  let {
    clientHeight: height,
    clientWidth: width,
  } = scenarioGraphicElement;


  for (let radius of [-1, 0, 1].map(e => RING_BASE + (RING_DIFFERENCE * e))) {
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

  return {
    x: ~~(width / 2),
    y: ~~(height / 2),
  }
}
