import * as React from 'react';
import {Component} from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import TableCell from '@mui/material/TableCell';
import {Paper, styled, tableCellClasses, TableFooter, TablePagination, TableSortLabel} from "@mui/material";

const StyledTableCell = styled(TableCell)(({theme}) => ({
    [`&.${tableCellClasses.head}`]: {
        backgroundColor: theme.palette.primary.light,
        color: theme.palette.common.black,
    },
    [`&.${tableCellClasses.body}`]: {
        fontSize: 14,
    },
}));

const headCells = [
    {
        id: 'NAME',
        label: 'Name',
    },
    {
        id: 'COLOR',
        label: 'Color',
    },
    {
        id: 'TAIL_LENGTH',
        label: 'Tail Length',
    },
    {
        id: 'WHISKERS_LENGTH',
        label: 'Whiskers Length',
    }
];

class ListOfCats extends Component {
    state = {
        content: [],
        totalElements: 0,
        size: 0,
        number: 0,
        direction: "ASC",
        orderBy: "ID"
    };

    queryString(query = {}) {
        const qs = Object.entries(query)
            .filter(pair => pair[1] !== undefined)
            .map(pair => pair.filter(i => i !== null).map(encodeURIComponent).join('='))
            .join('&');

        return qs && '?' + qs;
    }

    async findAllCats(offset, limit, order, attribute) {
        const pageParam = this.queryString({offset: offset, limit: limit, order: order, attribute: attribute});
        const response = await fetch('/cat-info/v1/cats' + pageParam);
        const body = await response.json();
        this.setState(body);
    }

    async componentDidMount() {
        await this.findAllCats(null, null, null, null)
    }

    handleChangePage = async (event, newPage) => {
        const limit = this.state.size;
        const offset = newPage * limit;
        await this.findAllCats(offset, limit, this.state.direction, this.state.orderBy);
    };

    handleChangeRowsPerPage = async (event) => {
        await this.findAllCats(0, parseInt(event.target.value, 10), this.state.direction, this.state.orderBy);
    };

    handleRequestSort = async (event, property) => {
        const isAsc = this.state.orderBy === property && this.state.direction === 'ASC';
        const order = isAsc ? 'DESC' : 'ASC';
        const limit = this.state.size;
        const offset = this.state.number * limit;
        this.setState({direction: order, orderBy: property});
        await this.findAllCats(offset, limit, order, property);
    };

    createSortHandler = (property) => (event) => {
        this.handleRequestSort(event, property);
    };

    render() {
        const {content, totalElements, number, size, direction, orderBy} = this.state;
        return (
            <TableContainer component={Paper}>
                <Table sx={{minWidth: 500}}>
                    <TableHead>
                        <TableRow>
                            {headCells.map((headCell) => (
                                <StyledTableCell key={headCell.id}
                                                 align={'left'}>
                                    <TableSortLabel
                                        active={orderBy === headCell.id}
                                        direction={orderBy === headCell.id ? direction.toLowerCase() : 'asc'}
                                        onClick={this.createSortHandler(headCell.id)}
                                    >
                                        {headCell.label}
                                    </TableSortLabel>
                                </StyledTableCell>
                            ))}
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {content.map((cat) => (
                            <TableRow key={cat.name}>
                                <TableCell component="th" scope="row">{cat.name}</TableCell>
                                <TableCell align="left">{cat.color}</TableCell>
                                <TableCell align="left">{cat.tailLength}</TableCell>
                                <TableCell align="left">{cat.whiskersLength}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                    <TableFooter>
                        <TableRow>
                            <TablePagination
                                rowsPerPageOptions={[5, 10, 25, {label: 'All', value: totalElements}]}
                                count={totalElements}
                                rowsPerPage={size}
                                page={number}
                                SelectProps={{
                                    inputProps: {
                                        'aria-label': 'rows per page',
                                    },
                                    native: true,
                                }}
                                onPageChange={this.handleChangePage}
                                onRowsPerPageChange={this.handleChangeRowsPerPage}
                            />
                        </TableRow>
                    </TableFooter>
                </Table>
            </TableContainer>
        );
    }
}

export default ListOfCats;